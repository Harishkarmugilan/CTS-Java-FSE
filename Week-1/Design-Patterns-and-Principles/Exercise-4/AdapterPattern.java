interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    public void makePayment(double amount) {
        System.out.println("Payment of ₹" + amount + " processed using PayPal.");
    }
}

class StripeGateway {
    public void pay(double amount) {
        System.out.println("Payment of ₹" + amount + " processed using Stripe.");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway gateway;

    public PayPalAdapter(PayPalGateway gateway) {
        this.gateway = gateway;
    }

    public void processPayment(double amount) {
        gateway.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway gateway;

    public StripeAdapter(StripeGateway gateway) {
        this.gateway = gateway;
    }

    public void processPayment(double amount) {
        gateway.pay(amount);
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPalAdapter(new PayPalGateway());
        paypal.processPayment(5000);

        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        stripe.processPayment(2500);
    }
}