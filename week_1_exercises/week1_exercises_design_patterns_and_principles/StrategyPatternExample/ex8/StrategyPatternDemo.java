package ex8;

public class StrategyPatternDemo {
 public static void main(String[] args) {
     PaymentContext paymentContext = new PaymentContext();
     paymentContext.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
     paymentContext.executePayment(200.00);
     paymentContext.setPaymentStrategy(new PayPalPayment("user@example.com"));
     paymentContext.executePayment(150.00);
 }
}

