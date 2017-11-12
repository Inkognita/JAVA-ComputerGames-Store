public class Game {
    private final String serialNumber;
    private double price;
    private GameSpec spec;
    private static Integer counter = 0;

    public Game(double price, GameSpec spec){
        this.price = price;
        this.serialNumber = Game.counter.toString();
        Game.counter++;
        this.spec = spec;
    }

    public GameSpec getSpec() {
        return spec;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }
}
