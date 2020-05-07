package app.modules.publisher;

import app.modules.stockdata.StockData;
import app.modules.subscriber.ISubscriber;

public interface IPublisher {
    StockData subscribe(ISubscriber subscriber);
    void unsubscribe(ISubscriber subscriber);
    void notifyAllSubscribers();
    boolean setStockData(ISubscriber subscriber, StockData data);
    StockData getStockData(ISubscriber subscriber);
}