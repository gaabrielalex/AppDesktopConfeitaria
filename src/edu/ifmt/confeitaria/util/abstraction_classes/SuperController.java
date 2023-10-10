package edu.ifmt.confeitaria.util.abstraction_classes;

public abstract class SuperController<T> {
    public abstract void displayView();
    public abstract Object[] modelToTableRow(T object);
    public abstract void modelToFields(T object);
    public abstract T fieldsToModel();
}
