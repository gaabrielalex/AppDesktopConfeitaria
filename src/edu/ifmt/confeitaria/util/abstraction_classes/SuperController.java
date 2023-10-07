  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ifmt.confeitaria.util.abstraction_classes;

import java.util.List;

/**
 *
 * @author Gabriel
 */
public abstract class SuperController<T> {
  
  public abstract void displayView();
  public abstract List<T> select();
  public abstract List<T> remakeLastSelect();
  public abstract void insert(T object);
}
    