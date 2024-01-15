package io.nwdaf.eventsubscription.requestbuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.nwdaf.eventsubscription.customModel.NefUeState;
import io.nwdaf.eventsubscription.model.NwdafEvent.NwdafEventEnum;
import io.nwdaf.eventsubscription.model.UeCommunication;
import io.nwdaf.eventsubscription.model.UeMobility;
import io.nwdaf.eventsubscription.responsebuilders.NotificationBuilder;
import io.nwdaf.eventsubscription.utilities.ConvertUtil;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.*;

public class NefRequestBuilder {

    private static final Logger log = LoggerFactory.getLogger(NefRequestBuilder.class);

    @Getter
    private final RestTemplate template;
    @Getter
    @Setter
    private String token;
    private Resource trustStore;

    public NefRequestBuilder(String token, Resource trustStore) {
        this.token = token;
        this.trustStore = trustStore;
        this.template = setupTemplate(trustStore);
    }

    private RestTemplate setupTemplate(Resource trustStore) {
        try {
            return new RestTemplate(Objects.requireNonNull(RestTemplateFactory.createRestTemplateFactory(trustStore, null)));
        } catch (IOException | CertificateException | NoSuchAlgorithmException | KeyStoreException |
                 KeyManagementException | NullPointerException e) {
            log.error("Error while creating RestTemplate", e);
        }
        return null;
    }

    public HttpEntity<MultiValueMap<String, String>> setupRequest(String token) {
        HttpHeaders headers = new HttpHeaders();

        headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
        headers.set(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, br");
        headers.set(HttpHeaders.CONNECTION, "keep-alive");
        headers.set(HttpHeaders.ACCEPT, "*/*");

//        String encoding = Base64.getEncoder().encodeToString((token).getBytes());
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        System.out.println("Token: " + token);

        return new HttpEntity<>(headers);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> execute(NwdafEventEnum eType, String nef_url, ObjectMapper objectMapper) throws JsonProcessingException, RestClientException {

        NotificationBuilder notifBuilder = new NotificationBuilder();
        HttpEntity<MultiValueMap<String, String>> request = setupRequest(token);
        Map<String, Object> json = null;

        if (eType.equals(NwdafEventEnum.UE_COMM) || eType.equals(NwdafEventEnum.UE_MOBILITY)) {
            String body = template.exchange(nef_url, HttpMethod.GET, request, String.class).getBody();
            json = objectMapper.readValue(body, new TypeReference<>() {});
        }
        if (json == null) {
            return null;
        }
        List<String> supiList = json.keySet().stream().toList();

        switch (eType) {
            case UE_MOBILITY:
                List<UeMobility> ueMobilities = new ArrayList<>();
                for (String supi : supiList) {
                    NefUeState nefUeState = objectMapper.convertValue(json.get(supi), NefUeState.class);
                    ueMobilities.add(ConvertUtil.mapNefUeStateToUeMobility(nefUeState));
                }
                return (List<T>) ueMobilities;
            case UE_COMM:
                List<UeCommunication> ueCommunications = new ArrayList<>();
                for (String supi : supiList) {
                    NefUeState nefUeState = objectMapper.convertValue(json.get(supi), NefUeState.class);
                    ueCommunications.add(ConvertUtil.mapNefUeStateToUeCommunication(nefUeState));
                }
                return (List<T>) ueCommunications;
            default:
                break;
        }

        return null;
    }
}
