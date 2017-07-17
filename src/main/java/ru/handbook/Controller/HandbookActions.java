package ru.handbook.Controller;
import ru.handbook.core.SystemMessages;
/**
 * Created by asus on 16.07.2017.
 */
public interface HandbookActions<T> {
    SystemMessages messenger = new SystemMessages();

    public void create();

    public T search();

    public void update();

    public void delete();

    public void check();
}
