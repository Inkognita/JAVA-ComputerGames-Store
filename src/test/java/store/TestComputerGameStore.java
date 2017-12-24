package store;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestComputerGameStore {


    @Test
    public void addingSingleGameTest() {
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
    public void addingMultipleGamesTest() {
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
    @Test
    public void cartTest() {
        ComputerGameStore store = new ComputerGameStore();
        GameSpec spec;
        double gamePrice = 25.;
        spec = new GameSpec("CS:GO", "Made in 2012",
                null, new Genre[]{Genre.ACTION, Genre.STRATEGY},
                new Language[]{Language.ENGLISH});
        Game game = store.addGame(gamePrice, spec);
        Cart cart = new Cart();
        cart.addGame(game);
        assertEquals(DeliveryNovaPoshta.class, cart.getDeliveryStrategy().getClass());
        assertEquals(Privat24Payment.class, cart.getPaymentStrategy().getClass());
        assertTrue(cart.getPaymentStrategy().pay(25));
        assertTrue(cart.ship());
        cart.setDeliveryStrategy(new DeliveryDHL());
        cart.setPaymentStrategy(new CashPayment());
        assertEquals(CashPayment.class, cart.getPaymentStrategy().getClass());
        assertTrue(cart.getPaymentStrategy().pay(25));
        assertEquals(DeliveryDHL.class, cart.getDeliveryStrategy().getClass());
        assertEquals(25, cart.computeTotalPrice(), 0.0001);
        assertTrue(cart.getGames().contains(game));
        assertTrue(cart.ship());
        assertEquals(0.8*25, new DiscountDecorator(cart).computeTotalPrice(), 0.001);
        new BonusDecorator(cart).ship();
    }
    @Test
    public void decoratorTest() {
        ComputerGameStore store = new ComputerGameStore();
        GameSpec spec;
        double gamePrice = 25.;
        spec = new GameSpec("CS:GO", "Made in 2012",
                null, new Genre[]{Genre.ACTION, Genre.STRATEGY},
                new Language[]{Language.ENGLISH});
        Game game = store.addGame(gamePrice, spec);
        CartInterface cart = new DiscountDecorator(new Cart());
        cart.addGame(game);
        assertEquals(DeliveryNovaPoshta.class, cart.getDeliveryStrategy().getClass());
        assertEquals(Privat24Payment.class, cart.getPaymentStrategy().getClass());
        assertTrue(cart.getPaymentStrategy().pay(25));
        assertTrue(cart.ship());
        cart.setDeliveryStrategy(new DeliveryDHL());
        cart.setPaymentStrategy(new CashPayment());
        assertEquals(CashPayment.class, cart.getPaymentStrategy().getClass());
        assertTrue(cart.getPaymentStrategy().pay(25));
        assertEquals(DeliveryDHL.class, cart.getDeliveryStrategy().getClass());
        assertEquals(25*0.8, cart.computeTotalPrice(), 0.0001);
        assertTrue(cart.getGames().contains(game));
        assertTrue(cart.ship());
        assertEquals(0.8*0.8*25, new DiscountDecorator(cart).computeTotalPrice(), 0.001);
    }
    @Test
    public void observableTest() {
        ComputerGameStore store = new ComputerGameStore();
        GameSpec spec;
        double gamePrice = 25.;
        spec = new GameSpec("CS:GO", "Made in 2012",
                null, new Genre[]{Genre.ACTION, Genre.STRATEGY},
                new Language[]{Language.ENGLISH});
        Game game = store.addGame(gamePrice, spec);
        Cart cart = new Cart();
        cart.addGame(game);
        Customer c1 = new Customer();
        Seller s1 = new Seller();
        cart.addObserver(c1);
        assertTrue(cart.getObservers().contains(c1));
        cart.notifyObservers("Test1");
        cart.removeObserver(c1);
        assertFalse(cart.getObservers().contains(c1));
        cart.addObserver(s1);
        assertTrue(s1.messages.isEmpty());
        cart.notifyObservers("Test2");
        assertTrue(s1.messages.contains("Test2"));
    }

}
