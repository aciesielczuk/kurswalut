package nbp;

import nbp.xml.ArrayOfExchangeRates;
import org.junit.jupiter.api.Test;
import org.mockserver.integration.ClientAndServer;
import static org.assertj.core.api.Assertions.*;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

class NBPApiClientTest {

    @Test
    void returnsXML() throws IOException, JAXBException {
        InputStream inputStream = getClass()
                .getClassLoader().getResourceAsStream("exchangeRates.xml");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuffer sb = new StringBuffer();
        String str;
        while ((str = reader.readLine()) != null) {
            sb.append(str);
        }
        System.out.println(sb.toString());
        ClientAndServer mockServer = startClientAndServer(1080);
        mockServer
                .when(
                        request()
                                .withMethod("GET")
                                .withPath("/api/exchangerates/tables/C/last/10")
                )
                .respond(
                        response()
                                .withStatusCode(200)
                                .withBody(sb.toString())
                );
        NBPApiClient nbpApiClient = new NBPApiClient("localhost:1080");
        ArrayOfExchangeRates result = nbpApiClient.getExchangeRates("A", 1);
        System.out.println(result.getExchangeRatesTables().get(0).getRates().get(0).getCurrency());

        assertThat(result.getExchangeRatesTables().get(0).getRates().get(0).getCurrency()).isEqualTo("dolar ameryka?ski");
    }
}