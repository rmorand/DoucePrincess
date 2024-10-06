package domaine;

public interface Pile<T> {

    void push(T val);

    T pop();
    int size();
    boolean isEmpty();

    Integer surfaceTotale();
}
