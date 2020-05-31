package exchangerates;

import exchangerates.xml.ArrayOfExchangeRates;
import exchangerates.xml.ArrayOfExchangeRatesFactory;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;

import static org.assertj.core.api.Assertions.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class NBPApiClientTest {

    @Test
    void returnsXML() throws IOException, JAXBException {
        NBPApiClient nbpApiClient = new NBPApiClient();
        String result = nbpApiClient.getExchangeRates("A", 1);
        assertThat(result).contains("ArrayOfExchangeRatesTable");

        ArrayOfExchangeRates unmarshalled = ArrayOfExchangeRatesFactory.fromXML(result);
        System.out.println(unmarshalled.getExchangeRatesTables().get(0).getRates().get(0).getCurrency());
    }
}