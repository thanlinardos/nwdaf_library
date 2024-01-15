package io.nwdaf.eventsubscription.requestbuilders;

import lombok.Getter;
import lombok.Setter;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.socket.ConnectionSocketFactory;
import org.apache.hc.client5.http.socket.PlainConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.http.config.Registry;
import org.apache.hc.core5.http.config.RegistryBuilder;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import org.apache.hc.core5.ssl.SSLContexts;
import org.apache.hc.core5.ssl.TrustStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;


@Getter
@Setter
public class RestTemplateFactory {

    private static final Logger logger = LoggerFactory.getLogger(RestTemplateFactory.class);

    public static ClientHttpRequestFactory createRestTemplateFactory(Resource trustStore, String trustStorePassword) throws IOException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
            RegistryBuilder<ConnectionSocketFactory> socketFactoryRegistryBuilder = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", new PlainConnectionSocketFactory());

            if(trustStore != null) {
                SSLContext sslContext;
                SSLConnectionSocketFactory sslConFactory;
                if(trustStorePassword != null) {
                    sslContext = new SSLContextBuilder()
                            .loadTrustMaterial(trustStore.getURL(), trustStorePassword.toCharArray()).build();
                    sslConFactory = new SSLConnectionSocketFactory(sslContext);
                } else {
                    TrustStrategy trustStrategy = (cert, authType) -> true;
                    sslContext = SSLContexts.custom().loadTrustMaterial(null, trustStrategy).build();
                    sslConFactory = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
                }
                socketFactoryRegistryBuilder.register("https", sslConFactory);
            }

            Registry<ConnectionSocketFactory> socketFactoryRegistry = socketFactoryRegistryBuilder.build();
            PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            connectionManager.setMaxTotal(2000);
            connectionManager.setDefaultMaxPerRoute(2000);

            CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
            return new HttpComponentsClientHttpRequestFactory(httpClient);
    }
}
