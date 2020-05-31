package nbp.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class ArrayOfExchangeRatesFactory {
    public static ArrayOfExchangeRates fromXML(String xml) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ArrayOfExchangeRates.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ArrayOfExchangeRates arrayOfExchangeRates = (ArrayOfExchangeRates) jaxbUnmarshaller.unmarshal(new StringReader(xml));
        return arrayOfExchangeRates;
    }
}
