package nbp;

import nbp.xml.ArrayOfExchangeRates;
import nbp.xml.ExchangeRatesTable;
import nbp.xml.Rate;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public static double getAverageAsk(String table, int topCount, String code) throws IOException, JAXBException {
        ExchangeRatesTable exchangeRatesTable = new NBPApiClient().getExchangeRates(table, topCount, code);
        List<Rate> rates = exchangeRatesTable.getRates();
        double sumOfAsk = 0;
        for (Rate rate : rates) {
            sumOfAsk += rate.getAsk();
        }
        return sumOfAsk/topCount;
    }

}
