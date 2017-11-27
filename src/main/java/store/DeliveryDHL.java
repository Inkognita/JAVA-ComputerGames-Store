package store;

import java.util.List;

public class DeliveryDHL implements DeliveryStrategy {
    @Override
    public boolean deliver(List<Game> games) {
        for (Game game : games) {
            System.out.printf("    %s was delivered using DHL.",game.getSpec().getName());
        }
        return true;
    }
}
