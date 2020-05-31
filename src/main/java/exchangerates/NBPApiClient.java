package exchangerates;


import exchangerates.xml.ArrayOfExchangeRates;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NBPApiClient {

    public ArrayOfExchangeRates getExchangeRates(String a, int i) throws IOException, JAXBException {
        URL url = new URL("http://api.nbp.pl/api/exchangerates/tables/C/last/10");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/xml");

        JAXBContext jaxbContext = JAXBContext.newInstance(ArrayOfExchangeRates.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ArrayOfExchangeRates arrayOfExchangeRates = (ArrayOfExchangeRates) jaxbUnmarshaller.unmarshal(new InputStreamReader(con.getInputStream()));
        con.disconnect();

        return arrayOfExchangeRates;
    }


}
