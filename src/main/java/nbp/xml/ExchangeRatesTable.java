package nbp.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "ExchangeRatesTable")
public class ExchangeRatesTable {

    public String getTable() {
        return table;
    }

    @XmlElement(name = "Table")
    private String table;

    public List<Rate> getRates() {
        return rates;
    }

    @XmlElementWrapper(name="Rates")
    @XmlElement(name="Rate")
    private List<Rate> rates;
}
