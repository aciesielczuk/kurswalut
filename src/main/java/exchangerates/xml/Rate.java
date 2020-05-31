package exchangerates.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Rate")
public class Rate {

    @XmlElement(name = "Currency")
    private String currency;

    @XmlElement(name = "Code")
    private String code;

    @XmlElement(name = "Bid")
    private double bid;

    @XmlElement(name = "Ask")
    private double ask;

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public double getBid() {
        return bid;
    }

    public double getAsk() {
        return ask;
    }
}
