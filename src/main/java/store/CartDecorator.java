package store;

import java.util.List;

public abstract class CartDecorator implements CartInterface {
    protected CartInterface cart;
    public CartDecorator(CartInterface cart){
        this.cart = cart;
    }

    @Override
    public boolean ship() {
        return cart.ship();
    }

    @Override
    public double computeTotalPrice(){
        return cart.computeTotalPrice();
    };

    @Override
    public void addGame(Game game) {
        cart.addGame(game);
    }

    @Override
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        cart.setPaymentStrategy(paymentStrategy);
    }

    @Override
    public void setDeliveryStrategy(DeliveryStrategy deliveryStrategy) {
        cart.setDeliveryStrategy(deliveryStrategy);
    }

    @Override
    public List<Game> getGames() {
        return cart.getGames();
    }

    @Override
    public DeliveryStrategy getDeliveryStrategy() {
        return cart.getDeliveryStrategy();
    }

    @Override
    public PaymentStrategy getPaymentStrategy() {
        return cart.getPaymentStrategy();
    }
}
