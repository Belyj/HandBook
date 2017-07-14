package ru.handbook.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by operator1 on 14.07.2017.
 */
public class Serialize implements Serializable {
    List<Object> objects = new ArrayList();

    public List<Object> getObjects() {
        return objects;
    }
}
