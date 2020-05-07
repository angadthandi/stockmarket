package app.modules.gitstock;

import app.modules.publisher.IPublisher;
import app.modules.stockdata.StockData;
import app.modules.subscriber.ISubscriber;

public class GitStock implements ISubscriber {
    IPublisher publisher;

    private final String SUBSCRIBER_NAME = "Git";
    private StockData stockData;

    public GitStock(IPublisher pub) {
        // self-register to the publisher
        // 
        // and store generated stock data
        stockData = pub.subscribe(this);

        publisher = pub;
    }

    public void udpate(IPublisher publisher) {
        stockData = publisher.getStockData(this);
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