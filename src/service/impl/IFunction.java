package service.impl;

import java.util.ArrayList;

public interface IFunction<T> {
    void input(ArrayList<T> ts);
    void output(ArrayList<T> ts);
    void remove(ArrayList<T> ts);
    void search(ArrayList<T> ts);
    void soft(ArrayList<T> ts);
    ArrayList<T> output5Staff(ArrayList<T> ts);
}
