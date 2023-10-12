package edu.ifmt.confeitaria.util.abstraction_classes;

import java.util.List;

public abstract class SuperService<T> {
    public static Long MAX_ID_VALUE = 9999999L;
    public static Long MIN_ID_VALUE = 1L;

    public abstract List<T> selectAll();
    public abstract List<T> redoLastPartialSearch();
    public abstract boolean insert(T object);
    public abstract boolean update(T object, T originalObject); 
}
