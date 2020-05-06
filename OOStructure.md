# OO Design Structure

##### Reference
https://leetcode.com/discuss/interview-question/object-oriented-design/613466/Design-a-stock-trading-system

---

## IPublisher Interface
 #### Attributes:
 - subscribers HashMap < ISubscriber > StockData
 #### Methods:
 - subscribe(ISubscriber subscriber)
 - unsubscribe(ISubscriber subscriber)
 - notify()
 - setStockValue(StockData data)

## ISubscriber Interface
 #### Attributes:
 - publisher IPublisher
 #### Methods:
 - udpate(IPublisher publisher)
 - getStockData()
 - unsubscribe()

---

## StockData Class
 #### Attributes:
 - StockPrice int

## StockMarket Class implements IPublisher
 #### Attributes:
 - subscribers HashMap < ISubscriber > StockData
 #### Methods:
 - subscribe(ISubscriber subscriber)
 - unsubscribe(ISubscriber subscriber)
 - notify()
 - setStockValue(StockData data)

## GitStock Class implements ISubscriber
 #### Attributes:
 - publisher IPublisher
 #### Methods:
 - udpate(IPublisher publisher)
 - getStockData() StockData
 - unsubscribe()
 - GitStock(IPublisher publisher) \
 // constructor self-registers to IPublisher

## GoogleStock Class implements ISubscriber
 #### Attributes:
 - publisher IPublisher
 #### Methods:
 - udpate(IPublisher publisher)
 - getStockData() StockData
 - unsubscribe()
 - GoogleStock(IPublisher publisher) \
 // constructor self-registers to IPublisher

## FacebookStock Class implements ISubscriber
 #### Attributes:
 - publisher IPublisher
 #### Methods:
 - udpate(IPublisher publisher)
 - getStockData() StockData
 - unsubscribe()
 - FacebookStock(IPublisher publisher) \
 // constructor self-registers to IPublisher

---

# Use Observer Pattern - with Publisher/Subscribers