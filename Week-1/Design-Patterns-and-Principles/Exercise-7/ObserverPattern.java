import java.util.*;

interface Observer {
    void update(double price);
}

interface Stock {
    void register(Observer o);
    void deregister(Observer o);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private double price;

    public void register(Observer o) {
        observers.add(o);
    }

    public void deregister(Observer o) {
        observers.remove(o);
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(price);
        }
    }
}

class MobileApp implements Observer {
    public void update(double price) {
        System.out.println("Mobile App: Stock price updated to ₹" + price);
    }
}

class WebApp implements Observer {
    public void update(double price) {
        System.out.println("Web App: Stock price updated to ₹" + price);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        StockMarket stock = new StockMarket();

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        stock.register(mobile);
        stock.register(web);

        stock.setPrice(1500);

        stock.deregister(web);

        stock.setPrice(1800);
    }
}