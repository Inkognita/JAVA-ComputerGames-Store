package store;

import java.util.List;

public interface DeliveryStrategy {
    boolean deliver(List<Game> games);
}
