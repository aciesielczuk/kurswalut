package nbp;

import nbp.xml.ArrayOfExchangeRates;
import nbp.xml.ExchangeRatesTable;
import nbp.xml.Rate;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public static double getAverageAsk(String table, int topCount) throws IOException, JAXBException {
        ArrayOfExchangeRates arrayOfExchangeRates = new NBPApiClient().getExchangeRates(table, topCount);
        List<ExchangeRatesTable> exchangeRatesTables = arrayOfExchangeRates.getExchangeRatesTables();
        List<Rate> rates = new ArrayList<>();
        for (int i = 0; i<topCount; i++) {
            rates.add(exchangeRatesTables.get(i).getRates().get(0));
        }
        double sumOfAsk = 0;
        for (Rate rate : rates) {
            sumOfAsk += rate.getAsk();
        }
        return sumOfAsk/topCount;
    }

}
