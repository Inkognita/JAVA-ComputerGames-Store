package store;

public class CashPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.printf("# You payed %f in cash.", amount);
        return true;
    }
}
