package ex7;

public class WebApp implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.println("WebApp: Stock " + stockName + " is now $" + price);
    }
}