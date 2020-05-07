package app.modules.gitstock;

import app.modules.publisher.IPublisher;
import app.modules.stockdata.StockData;
import app.modules.subscriber.ISubscriber;

public class GitStock implements ISubscriber {
    IPublisher publisher;

    public void udpate(IPublisher publisher) {

    }

    public StockData getStockData() {
        StockData data = new StockData();

        return data;
    }

    public void unsubscribe() {

    }

}