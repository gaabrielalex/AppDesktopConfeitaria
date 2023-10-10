package edu.ifmt.confeitaria.util.abstraction_classes;

import java.util.List;

public abstract class SuperService<T> {
    public abstract List<T> select();
    public abstract List<T> remakeLastSelect();
    public abstract boolean insert(T object);
    public abstract boolean update(T object, T originalObject); 
}
