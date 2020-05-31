package exchangerates.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExchangeRatesTable {

    @XmlElement
    private String table;
}
