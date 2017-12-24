package store;

import java.util.ArrayList;
import java.util.List;

public abstract class User implements Observer {
    public List<String> messages;
    @Override
    public void update(String msg) {
        messages.add(msg);
    }
    public User(){
        messages = new ArrayList<>();
    }
}
