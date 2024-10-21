package metier;

public interface File<T> {

    void add(T val);
    T remove();
    int size();
    boolean isEmpty();
    void resize();

}
