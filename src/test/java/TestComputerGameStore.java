import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.List;

public class TestComputerGameStore {
    @Test
    public void addingSingleGameTest(){
        ComputerGameStore store = new ComputerGameStore();
        GameSpec spec;
        spec = new GameSpec("CS:GO", "Made in 2012",
                null, new Genre[]{Genre.ACTION, Genre.STRATEGY},
                new Language[]{Language.ENGLISH});
        Game createdGame = store.addGame(5.6, spec);
        List<Game> foundGames = store.search(spec);
        assertTrue(foundGames.contains(createdGame));
        assertEquals(5.6, createdGame.getPrice(), 0.1);
        assertEquals(new Integer(0), createdGame.getSpec().getAgeRestrictions());
        assertTrue(createdGame.getSpec().getGenres().contains(Genre.ACTION));
        assertFalse(createdGame.getSpec().getGenres().contains(Genre.SIMULATION));
    }
    @Test
    public void addingMultipleGamesTest(){
        ComputerGameStore store = new ComputerGameStore();
        GameSpec spec;
        spec = new GameSpec("CS:GO", "Made in 2012",
                null, new Genre[]{Genre.ACTION, Genre.STRATEGY},
                new Language[]{Language.ENGLISH});
        Game createdGame1 = store.addGame(5.6, spec);
        spec = new GameSpec("CS:G", "Made in 20",
                18, new Genre[]{Genre.SIMULATION, Genre.STRATEGY},
                new Language[]{Language.ENGLISH, Language.UKRAINIAN});
        Game createdGame2 = store.addGame(8, spec);
        spec = new GameSpec("CS", "Made",
                255, new Genre[]{Genre.STRATEGY}, null);
        assertTrue(store.search(spec).contains(createdGame1));
        assertTrue(store.search(spec).contains(createdGame2));
        assertEquals(createdGame2, store.get("1"));
    }
}
