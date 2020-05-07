package app.modules.subscriber;

import app.modules.publisher.IPublisher;
import app.modules.stockdata.StockData;

public interface ISubscriber {
    void udpate(IPublisher publisher);
    StockData getStockData();
    void unsubscribe();
    String getSubsriberName();
}