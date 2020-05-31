package exchangerates.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class ArrayOfExchangeRates {

    @XmlElement
    private List<ExchangeRatesTable> exchangeRatesTables;

}
