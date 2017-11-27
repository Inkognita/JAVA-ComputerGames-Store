package store;

import java.util.ArrayList;
import java.util.List;

public class Cart extends Observable implements CartInterface {
    private List<Game> games;
    private PaymentStrategy paymentStrategy;
    private DeliveryStrategy deliveryStrategy;
    public Cart(){
        games = new ArrayList<>();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update("Something went wrong");
        }
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public DeliveryStrategy getDeliveryStrategy() {
        return deliveryStrategy;
    }

    public void setDeliveryStrategy(DeliveryStrategy deliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy;
    }

    public List<Game> getGames() {
        return games;
    }
    public void addGame(Game game){
        games.add(game);
    }

    @Override
    public boolean ship() {
        return deliveryStrategy.deliver(games);
    }

    @Override
    public double computeTotalPrice() {
        double price = 0;
        for (Game game : games) {
            price += game.getPrice();
        }
        return price;
    }
}
