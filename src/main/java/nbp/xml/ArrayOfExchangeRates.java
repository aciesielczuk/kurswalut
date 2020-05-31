package nbp.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "ArrayOfExchangeRatesTable")
@XmlAccessorType(XmlAccessType.FIELD)
public class ArrayOfExchangeRates {

    @XmlElement(name = "ExchangeRatesTable")
    private List<ExchangeRatesTable> exchangeRatesTables;

    public List<ExchangeRatesTable> getExchangeRatesTables() {
        return exchangeRatesTables;
    }
}
