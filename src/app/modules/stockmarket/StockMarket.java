package app.modules.stockmarket;

import java.util.HashMap;

import app.modules.publisher.IPublisher;
import app.modules.stockdata.StockData;
import app.modules.subscriber.ISubscriber;

public class StockMarket implements IPublisher {
    private HashMap<ISubscriber, StockData> subscribers = new HashMap<ISubscriber, StockData>();

    public StockData subscribe(ISubscriber subscriber) {
        StockData sd = StockData.generateRandomStockData(subscriber.getSubsriberName());

        subscribers.put(subscriber, sd);

        return sd;
    }

    public void unsubscribe(ISubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifyAllSubscribers() {
        for ( HashMap.Entry mapElem : subscribers.entrySet() ) {
            ISubscriber subscriber = (ISubscriber)mapElem.getKey();

            subscriber.udpate(this);
        }
    }

    public boolean setStockData(ISubscriber subscriber, StockData data) {
        if (subscribers.containsKey(subscriber)) {
            StockData sd = subscribers.get(subscriber);
            sd.StockPrice = data.StockPrice;
            subscribers.put(subscriber, sd);

            // notify subscriber
            subscriber.udpate(this);

            return true;
        }

        return false;
    }

    public StockData getStockData(ISubscriber subscriber) {
        return subscribers.get(subscriber);
    }

}