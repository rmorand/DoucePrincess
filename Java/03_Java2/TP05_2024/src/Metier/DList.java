package Metier;

public interface DList<T> {
    void addFirst(T val);
    void addLast(T val);
    T removeFirst(); // dans les deux sens
    T removeLast();
    boolean isEmpty();

}
