package edu.ifmt.confeitaria.util.abstraction_classes;

import java.util.List;

public abstract class SuperService<T> {
    public abstract List<T> selectAll();
    public abstract List<T> remakeLastPartialSearch();
    public abstract boolean insert(T object);
    public abstract boolean update(T object, T originalObject); 
}
