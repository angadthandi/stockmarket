package app.modules.googlestock;

import app.modules.publisher.IPublisher;
import app.modules.stockdata.StockData;
import app.modules.subscriber.ISubscriber;

public class GoogleStock implements ISubscriber {
    IPublisher publisher;

    private final String SUBSCRIBER_NAME = "Google";
    private StockData stockData;

    public GoogleStock(IPublisher pub) {
        // self-register to the publisher
        // 
        // and store generated stock data
        stockData = pub.subscribe(this);

        publisher = pub;
    }

    public void udpate(IPublisher publisher) {
        stockData = publisher.getStockData(this);

        System.out.printf(
            "Notification: Updated %s StockPrice: %f \n",
            this.SUBSCRIBER_NAME,
            stockData.StockPrice
        );
    }

    public StockData getStockData() {
        return stockData;
    }

    public void unsubscribe() {
        publisher.unsubscribe(this);
    }

    public String getSubsriberName() {
        return SUBSCRIBER_NAME;
    }

}