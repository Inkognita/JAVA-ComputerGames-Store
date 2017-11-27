package store;

public interface PaymentStrategy {
    boolean pay(double amount);
}
