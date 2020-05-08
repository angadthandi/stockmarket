package client;

import app.modules.gitstock.GitStock;
import app.modules.googlestock.GoogleStock;
import app.modules.stockdata.StockData;
import app.modules.stockmarket.StockMarket;

public class TestStockMarket {

    public static TestMetric Run() {
        int totalTests = 0;
        int totalPassed = 0;
        int totalFailed = 0;

        if (TestGitStock()) {
            totalTests += 1;
            totalPassed += 1;
        } else {
            totalTests += 1;
            totalFailed += 1;
        }

        if (TestMultipleStocks()) {
            totalTests += 1;
            totalPassed += 1;
        } else {
            totalTests += 1;
            totalFailed += 1;
        }

        if (TestMultipleSubscribers()) {
            totalTests += 1;
            totalPassed += 1;
        } else {
            totalTests += 1;
            totalFailed += 1;
        }

        TestMetric t = new TestMetric();
        t.Total = totalTests;
        t.Pass = totalPassed;
        t.Fail = totalFailed;

        return t;
    }

    public static boolean TestGitStock() {
        boolean pass = false;

        // SETUP ------------------------------------
        StockMarket stockMarket = new StockMarket();

        GitStock gitStock = new GitStock(stockMarket);
        // /SETUP ------------------------------------

        StockData gitStockData = gitStock.getStockData();
        // System.out.printf("GitStockID: %s \n", gitStockData.StockID);
        // System.out.printf("GitStockName: %s \n", gitStockData.StockName);
        // System.out.printf("GitStockPrice: %f \n", gitStockData.StockPrice);

        StockData updateGitStockData = new StockData();
        updateGitStockData.StockPrice = 72.5;
        stockMarket.setStockData(gitStock, updateGitStockData);

        StockData updatedGitStockData = gitStock.getStockData();
        // System.out.printf("GitStockID: %s \n", updatedGitStockData.StockID);
        // System.out.printf("GitStockName: %s \n", updatedGitStockData.StockName);
        // System.out.printf("GitStockPrice: %f \n", updatedGitStockData.StockPrice);

        if (gitStockData.StockPrice != updatedGitStockData.StockPrice) {
            System.out.printf(
                "FAIL : TestGitStock(); v1 = %f; v2 = %f \n",
                gitStockData.StockPrice,
                updatedGitStockData.StockPrice
            );
            return pass;
        }

        pass = true;

        return pass;
    }

    public static boolean TestMultipleStocks() {
        boolean pass = false;

        // SETUP ------------------------------------
        StockMarket stockMarket = new StockMarket();

        GitStock gitStock = new GitStock(stockMarket);
        GoogleStock googleStock = new GoogleStock(stockMarket);
        // /SETUP ------------------------------------

        stockMarket.notifyAllSubscribers();
        
        StockData updatdGitData = new StockData();
        updatdGitData.StockPrice = 88.88;
        stockMarket.setStockData(gitStock, updatdGitData);

        StockData gitStockData = gitStock.getStockData();
        if (gitStockData.StockPrice != updatdGitData.StockPrice) {
            System.out.printf(
                "FAIL : TestMultipleStocks(); v1 = %f; v2 = %f \n",
                gitStockData.StockPrice,
                updatdGitData.StockPrice
            );
            return pass;
        }

        StockData updatdGoogleData = new StockData();
        updatdGoogleData.StockPrice = 99.99;
        stockMarket.setStockData(googleStock, updatdGoogleData);

        StockData googleStockData = googleStock.getStockData();
        if (googleStockData.StockPrice != updatdGoogleData.StockPrice) {
            System.out.printf(
                "FAIL : TestMultipleStocks(); v1 = %f; v2 = %f \n",
                googleStockData.StockPrice,
                updatdGoogleData.StockPrice
            );
            return pass;
        }

        pass = true;

        return pass;
    }

    public static boolean TestMultipleSubscribers() {
        boolean pass = false;

        // SETUP ------------------------------------
        StockMarket stockMarket = new StockMarket();

        GitStock gitStock = new GitStock(stockMarket);
        GoogleStock googleStock = new GoogleStock(stockMarket);
        // /SETUP ------------------------------------

        int totalSubscribers = stockMarket.getTotalSubscribers();
        if (totalSubscribers != 2) {
            System.out.printf(
                "FAIL : TestMultipleSubscribers(); totalSubscribers = %f; \n",
                totalSubscribers
            );
            return pass;
        }

        gitStock.unsubscribe();
        int totalSubscribers1 = stockMarket.getTotalSubscribers();
        if (totalSubscribers1 != 1) {
            System.out.printf(
                "FAIL : TestMultipleSubscribers(); totalSubscribers = %f; \n",
                totalSubscribers1
            );
            return pass;
        }

        googleStock.unsubscribe();
        int totalSubscribers0 = stockMarket.getTotalSubscribers();
        if (totalSubscribers0 != 0) {
            System.out.printf(
                "FAIL : TestMultipleSubscribers(); totalSubscribers = %f; \n",
                totalSubscribers0
            );
            return pass;
        }

        pass = true;

        return pass;
    }

}