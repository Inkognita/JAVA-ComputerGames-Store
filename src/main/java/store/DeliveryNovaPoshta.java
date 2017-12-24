package store;

import java.util.List;

public class DeliveryNovaPoshta implements DeliveryStrategy {
    @Override
    public boolean deliver(List<Game> games) {
        for (Game game : games) {
            System.out.printf("    %s was delivered using NovaPoshta.",game.getSpec().getName());
        }
        return true;
    }
}
