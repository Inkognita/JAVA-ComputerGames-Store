package store;

public abstract class User implements Observer {
    @Override
    public void update(String msg) {
        System.out.println(msg);
    }
}
