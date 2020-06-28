package nbp.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStreamReader;
import java.io.StringReader;

public class ArrayOfExchangeRatesFactory {
    public static ArrayOfExchangeRates fromXML(InputStreamReader streamReader) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ArrayOfExchangeRates.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ArrayOfExchangeRates arrayOfExchangeRates = (ArrayOfExchangeRates) jaxbUnmarshaller.unmarshal(streamReader);
        return arrayOfExchangeRates;
    }

    public static ExchangeRatesTable exchangeRatesFromXML(InputStreamReader streamReader) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ExchangeRatesTable.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ExchangeRatesTable exchangeRatesTable = (ExchangeRatesTable) jaxbUnmarshaller.unmarshal(streamReader);
        return exchangeRatesTable;
    }
}
