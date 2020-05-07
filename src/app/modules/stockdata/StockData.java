package app.modules.stockdata;

import java.util.UUID;

public class StockData {
    public String StockID;
    public double StockPrice;
    public String StockName;

    public static StockData generateRandomStockData(String name) {
        StockData sd = new StockData();
        sd.StockID = UUID.randomUUID().toString();

        int min = 50;
        int max = 100;
        //Generate random double value from 50 to 100 
        sd.StockPrice = Math.random() * (max - min + 1) + min;

        sd.StockName = name;

        return sd;
    }

}