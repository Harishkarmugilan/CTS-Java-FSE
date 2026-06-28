interface Notifier {
    void send();
}

class EmailNotifier implements Notifier {
    public void send() {
        System.out.println("Email notification sent.");
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send() {
        notifier.send();
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send() {
        super.send();
        System.out.println("SMS notification sent.");
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send() {
        super.send();
        System.out.println("Slack notification sent.");
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Notifier notifier = new SlackNotifierDecorator(
                                new SMSNotifierDecorator(
                                    new EmailNotifier()));

        notifier.send();
    }
}