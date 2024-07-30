package ex6;

public class ProxyPatternDemo {
 public static void main(String[] args) {
     Image image1 = new ProxyImage("test_image.jpg");
     System.out.println("First call to display:");
     image1.display();
     System.out.println("\nSecond call to display:");
     image1.display();
 }
}

