package store;

public class DiscountDecorator extends CartDecorator {
    public DiscountDecorator(CartInterface cart){
        super(cart);
    }
    @Override
    public double computeTotalPrice(){
        return 0.8 * cart.computeTotalPrice();
    }
}
