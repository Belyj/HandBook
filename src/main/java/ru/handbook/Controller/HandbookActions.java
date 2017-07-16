package ru.handbook.Controller;
import ru.handbook.core.Messenger;
/**
 * Created by asus on 16.07.2017.
 */
public interface HandbookActions {
    Messenger messenger = new Messenger();

    public void create();

    public void search();

    public void update();

    public void delete();

    public void check();
}
