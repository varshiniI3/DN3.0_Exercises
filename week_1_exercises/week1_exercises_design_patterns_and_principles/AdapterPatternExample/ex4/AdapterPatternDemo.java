package ex4;
public class AdapterPatternDemo {
 public static void main(String[] args) {
     PayPalGateway payPalGateway = new PayPalGateway();
     StripeGateway stripeGateway = new StripeGateway();
     PaymentProcessor payPalProcessor = new PayPalAdapter(payPalGateway);
     PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);
     System.out.println("Using PayPal Adapter:");
     payPalProcessor.processPayment(150.00);
     System.out.println("\nUsing Stripe Adapter:");
     stripeProcessor.processPayment(200.00);
 }
}

