package ex5;

public class DecoratorPatternDemo {
 public static void main(String[] args) {
     Notifier emailNotifier = new EmailNotifier();
     Notifier smsEmailNotifier = new SMSNotifierDecorator(emailNotifier);
     Notifier slackSMSNotifier = new SlackNotifierDecorator(smsEmailNotifier);
     System.out.println("Sending notifications with all decorators:");
     slackSMSNotifier.send("Hello, this is a test notification!");
 }
}

