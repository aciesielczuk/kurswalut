package exchangerates;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NBPApiClientTest {

    @Test
    void returnsXML() {
        NBPApiClient nbpApiClient = new NBPApiClient();
        String result = nbpApiClient.getExchangeRates("A", 1);
        assertEquals("OK", result);
    }
}