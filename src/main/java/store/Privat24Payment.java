package store;

public class Privat24Payment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.printf("You payed %f using Privat24, thank you=)", amount);
        return true;
    }
}
