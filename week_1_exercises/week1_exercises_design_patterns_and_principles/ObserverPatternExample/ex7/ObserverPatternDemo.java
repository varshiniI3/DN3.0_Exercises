package ex7;

public class ObserverPatternDemo {
 public static void main(String[] args) {
     StockMarket stockMarket = new StockMarket("AAPL");
     Observer mobileApp = new MobileApp();
     Observer webApp = new WebApp();
     stockMarket.registerObserver(mobileApp);
     stockMarket.registerObserver(webApp);
     stockMarket.setPrice(150.00);
     stockMarket.setPrice(155.00);
     stockMarket.deregisterObserver(webApp);
     stockMarket.setPrice(160.00);
 }
}

