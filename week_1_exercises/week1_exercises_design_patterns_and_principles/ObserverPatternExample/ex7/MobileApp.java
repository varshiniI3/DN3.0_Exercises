package ex7;

public class MobileApp implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.println("MobileApp: Stock " + stockName + " is now $" + price);
    }
}
