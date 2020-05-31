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
        ArrayOfExchangeRates result = nbpApiClient.getExchangeRates("A", 1);
        System.out.println(result.getExchangeRatesTables().get(0).getRates().get(0).getCurrency());
    }
}