package app.modules.stockmarket;

import java.util.HashMap;

import app.modules.publisher.IPublisher;
import app.modules.stockdata.StockData;
import app.modules.subscriber.ISubscriber;

public class StockMarket implements IPublisher {
    HashMap<ISubscriber, StockData> subscribers;

    public void subscribe(ISubscriber subscriber) {

    }

    public void unsubscribe(ISubscriber subscriber) {

    }

    public void notifyAllSubscribers() {

    }

    public void setStockData(StockData data) {

    }

}