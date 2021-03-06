package store;

import java.util.ArrayList;
import java.util.List;

public class ComputerGameStore {
    private ArrayList<Game> inventory;

    public ComputerGameStore() {
        inventory = new ArrayList<>();
    }

    public Game addGame(double price, GameSpec spec) {
        Game game = new Game(price, spec);
        inventory.add(game);
        return game;
    }

    public Game get(String serialNumber) {
        for (Game game : inventory) {
            if (game.getSerialNumber().equals(serialNumber)) {
                return game;
            }
        }
        return null;
    }

    public List<Game> search(GameSpec spec) {
        List<Game> matchedGames = new ArrayList<>();
        for (Game game : inventory) {
            if (game.getSpec().matches(spec)) {
                matchedGames.add(game);
            }
        }
        return matchedGames;
    }
}
