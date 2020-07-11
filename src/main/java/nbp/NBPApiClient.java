package nbp;

import nbp.xml.ArrayOfExchangeRates;
import nbp.xml.ArrayOfExchangeRatesFactory;
import nbp.xml.ExchangeRatesTable;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NBPApiClient {

    private final String baseURL;

    public NBPApiClient(String baseURL) {
        this.baseURL = baseURL;
    }

    public NBPApiClient() {
        this.baseURL = "api.nbp.pl";
    }

    public ArrayOfExchangeRates getExchangeRates(String a, int i) throws IOException, JAXBException {
        URL url = new URL("http://" + baseURL + "/api/exchangerates/tables/" + a + "/last/" + i);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/xml");

        ArrayOfExchangeRates arrayOfExchangeRates = ArrayOfExchangeRatesFactory.fromXML(new InputStreamReader(con.getInputStream()));
        con.disconnect();

        return arrayOfExchangeRates;
    }

    public ExchangeRatesTable getExchangeRates(String a, int i, String code) throws IOException, JAXBException {
        URL url = new URL("http://" + baseURL + "/api/exchangerates/rates/" + a + "/" + code + "/last/" + i);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/xml");

        ExchangeRatesTable exchangeRatesTable = ArrayOfExchangeRatesFactory.exchangeRatesFromXML(new InputStreamReader(con.getInputStream()));
        con.disconnect();

        return exchangeRatesTable;
    }

}
