package nbp.xml;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "ExchangeRatesSeries")
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
