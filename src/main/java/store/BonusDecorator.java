package store;

public class BonusDecorator extends CartDecorator {
    public BonusDecorator(CartInterface cart){
        super(cart);
    }
    @Override
    public boolean ship(){
        System.out.println("Your delivery would be free");
        return cart.ship();
    }
}
