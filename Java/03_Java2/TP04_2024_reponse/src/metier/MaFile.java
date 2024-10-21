package metier;

public class MaFile<T> implements File<T> {
    // in : Prochaine cellule qui va recevoir une valeur
    // out: Prochaine cellule qui va éjecter une valeur
    private T[] tab;
    private int in, out, size;
    private int DEFAULT_SIZE = 5;

    public MaFile() {
        in = out = size = 0;
        tab = (T[]) new Object[DEFAULT_SIZE];
    }


    int incr(int val) {
        if ((val + 1) >= tab.length) {
            return 0;
        } else {
            return val + 1;
        }
       // return (val + 1) % tab.length;    Autre solution
    }

    @Override
    public void add(T val) {
        if (size >= tab.length) {
            resize();
        }
        tab[in] = val;
        in = incr(in);
        size++;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new RuntimeException("File vide !");
        }
        T val = tab[out];
        out = incr(out);
        size--;
        return val;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void resize() {
        T[] newTab = (T[]) new Object[tab.length*2];
        for (int i = 0; i < size; i++) {
            newTab[i] = tab[out];
            out = incr(out);
        }
        tab = newTab;
        in = size;
        out = 0;
    }


}



