package exchangerates;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class NBPApiClientTest {

    @Test
    void returnsXML() throws IOException {
        NBPApiClient nbpApiClient = new NBPApiClient();
        String result = nbpApiClient.getExchangeRates("A", 1);
       // assertEquals("OK", result);
        assertThat(result).contains("ArrayOfExchangeRatesTable");
    }
}