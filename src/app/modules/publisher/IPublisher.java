package app.modules.publisher;

import app.modules.stockdata.StockData;
import app.modules.subscriber.ISubscriber;

public interface IPublisher {
    void subscribe(ISubscriber subscriber);
    void unsubscribe(ISubscriber subscriber);
    void notifyAllSubscribers();
    void setStockData(StockData data);
}