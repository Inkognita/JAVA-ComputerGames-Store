package store;

import java.util.List;

public interface CartInterface {
    boolean ship();
    double computeTotalPrice();
    void addGame(Game game);
    void setPaymentStrategy(PaymentStrategy paymentStrategy);
    void setDeliveryStrategy(DeliveryStrategy deliveryStrategy);
    List<Game> getGames();
    DeliveryStrategy getDeliveryStrategy();
    PaymentStrategy getPaymentStrategy();
}
