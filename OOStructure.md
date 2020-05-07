# OO Design Structure

##### Reference
https://leetcode.com/discuss/interview-question/object-oriented-design/613466/Design-a-stock-trading-system

---

## IPublisher Interface
 #### Attributes:
 - subscribers HashMap < ISubscriber > StockData
 #### Methods:
 - subscribe(ISubscriber subscriber) StockData
 - unsubscribe(ISubscriber subscriber)
 - notifyAllSubscribers()
 - setStockData(ISubscriber subscriber, StockData data) boolean
 - getStockData(ISubscriber subscriber) StockData

## ISubscriber Interface
 #### Attributes:
 - publisher IPublisher
 #### Methods:
 - udpate(IPublisher publisher)
 - getStockData()
 - unsubscribe()
 - getSubsriberName() String

---

## StockData Class
 #### Attributes:
 - StockID String
 - StockPrice double
 - StockName String

## StockMarket Class implements IPublisher
 #### Attributes:
 - subscribers HashMap < ISubscriber > StockData
 #### Methods:
 - subscribe(ISubscriber subscriber) StockData
 - unsubscribe(ISubscriber subscriber)
 - notifyAllSubscribers()
 - setStockData(ISubscriber subscriber, StockData data) boolean
 - getStockData(ISubscriber subscriber) StockData

## GitStock Class implements ISubscriber
 #### Attributes:
 - publisher IPublisher
 #### Methods:
 - udpate(IPublisher publisher)
 - getStockData() StockData
 - unsubscribe()
 - getSubsriberName() String
 - GitStock(IPublisher publisher) \
 // constructor self-registers to IPublisher

## GoogleStock Class implements ISubscriber
 #### Attributes:
 - publisher IPublisher
 #### Methods:
 - udpate(IPublisher publisher)
 - getStockData() StockData
 - unsubscribe()
 - getSubsriberName() String
 - GoogleStock(IPublisher publisher) \
 // constructor self-registers to IPublisher

## FacebookStock Class implements ISubscriber
 #### Attributes:
 - publisher IPublisher
 #### Methods:
 - udpate(IPublisher publisher)
 - getStockData() StockData
 - unsubscribe()
 - getSubsriberName() String
 - FacebookStock(IPublisher publisher) \
 // constructor self-registers to IPublisher

---

# Use Observer Pattern - with Publisher/Subscribers