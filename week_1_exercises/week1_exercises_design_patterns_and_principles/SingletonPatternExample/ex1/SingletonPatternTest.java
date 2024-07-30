package ex1;

public class SingletonPatternTest {
	public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log("First log message");
        logger2.log("Second log message");
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 reference the same instance.");
        } else {
            System.out.println("logger1 and logger2 reference different instances.");
        }
    }
}
