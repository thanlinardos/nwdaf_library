package io.nwdaf.eventsubscription.requestbuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.nwdaf.eventsubscription.customModel.NefCell;
import io.nwdaf.eventsubscription.customModel.NefScenario;
import io.nwdaf.eventsubscription.customModel.NefUeState;
import io.nwdaf.eventsubscription.model.NwdafEvent.NwdafEventEnum;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.*;

import static io.nwdaf.eventsubscription.utilities.ConvertUtil.mapNefUeStateToUeCommunication;
import static io.nwdaf.eventsubscription.utilities.ConvertUtil.mapNefUeStateToUeMobility;

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
            return new RestTemplate(Objects.requireNonNull(RestTemplateFactory
                    .createRestTemplateFactory(trustStore, null)));
        } catch (IOException | CertificateException | NoSuchAlgorithmException | KeyStoreException |
                 KeyManagementException | NullPointerException e) {
            log.error("Error while creating RestTemplate", e);
        }
        return null;
    }

    public HttpEntity<MultiValueMap<String, String>> setupGetRequest(String token) {
        HttpHeaders headers = createHttpHeaders(token);
        return new HttpEntity<>(headers);
    }

    public <T> HttpEntity<T> setupPostRequest(String token, T body) {
        HttpHeaders headers = token != null ? createHttpHeaders(token) : createLoginHeaders();
        return new HttpEntity<>(body, headers);
    }

    private static HttpHeaders createHttpHeaders(String token) {
        HttpHeaders headers = new HttpHeaders();

        headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
        headers.set(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, br");
        headers.set(HttpHeaders.CONNECTION, "keep-alive");
        headers.set(HttpHeaders.ACCEPT, "*/*");
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        return headers;
    }

    private static HttpHeaders createLoginHeaders() {
        HttpHeaders headers = new HttpHeaders();

        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        headers.set(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, br");
        headers.set(HttpHeaders.CONNECTION, "keep-alive");
        headers.set(HttpHeaders.ACCEPT, "*/*");
        return headers;
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> getUEMetrics(NwdafEventEnum eType, String nef_url, String groupId, ObjectMapper objectMapper, List<NefCell> cells)
            throws JsonProcessingException, RestClientException {

        HttpEntity<MultiValueMap<String, String>> request = setupGetRequest(token);
        Map<String, Object> json = null;

        if (eType.equals(NwdafEventEnum.UE_COMM) || eType.equals(NwdafEventEnum.UE_MOBILITY)) {
            String body = template.exchange(nef_url, HttpMethod.GET, request, String.class).getBody();
            json = objectMapper.readValue(body, new TypeReference<>() {
            });
        }
        if (json == null) {
            return null;
        }

        return switch (eType) {
            case UE_MOBILITY -> (List<T>) json.values().stream().map(ue -> {
                NefUeState nefUeState = objectMapper.convertValue(ue, NefUeState.class);
                NefCell cell = cells.stream()
                        .filter(c -> c.getCell_id().equals(nefUeState.getCell_id_hex()))
                        .findFirst()
                        .orElse(null);
                return mapNefUeStateToUeMobility(nefUeState, cell).intGroupId(groupId);
            }).toList();
            case UE_COMM -> (List<T>) json.values().stream().map(ue -> {
                NefUeState nefUeState = objectMapper.convertValue(ue, NefUeState.class);
                return mapNefUeStateToUeCommunication(nefUeState).intGroupId(groupId);
            }).toList();
            default -> null;
        };
    }
}
