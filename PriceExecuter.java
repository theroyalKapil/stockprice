import model.StockDetail;
import service.ExecutionServiceImpl;
import service.PriceListenerImpl;
import service.PriceSourceImpl;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class PriceExecuter {

    public static void main(String[] args) {
        PriceExecuter priceExecuter = new PriceExecuter();
        priceExecuter.priceExecuter();
    }

    public void priceExecuter(){
        ExecutionServiceImpl executionService= new ExecutionServiceImpl();

        //Storage of stock details
        Map<String, StockDetail> stockDetail = new HashMap<String, StockDetail>();
        stockDetail.put("IBM",new StockDetail("IBM",100,5));
        stockDetail.put("TCS",new StockDetail("TCS",99,10));

        //connect to the  Price source
        PriceSourceImpl priceSource = new PriceSourceImpl();
        PriceListenerImpl priceListener = new PriceListenerImpl();
        priceSource.addPriceListener(priceListener);

        //Monitor price movement for specified stock
        //retrieve details for monitor
        StockDetail stockDetailRetrivedForMonitoring = stockDetail.get("IBM");

        //Execute single buy or sell
        if(stockDetailRetrivedForMonitoring.getStockName().equals("IBM")
                && stockDetailRetrivedForMonitoring.getSingleStockPrice() > 100){
            executionService.sell("DBUSER",105,5);
            System.out.println("Stock limit is above so auto triggered happen for sold");
        }
        else
        {
            executionService.buy("DBUSER",99,5);
            System.out.println("Stock limit is below so auto triggered happened for buy");
        }
    }
}
