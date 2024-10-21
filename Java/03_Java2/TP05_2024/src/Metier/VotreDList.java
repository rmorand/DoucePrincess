package Metier;

public class VotreDList<T> implements DList<T> {

    private Noeud first;
    private Noeud last;


    class Noeud {
        private T data;
        private Noeud next;
        private Noeud prev;

        public Noeud(T data) {
            this.data = data;
        }
    }

    public VotreDList() {
        this.first = null;
        this.last = null;
    }

    @Override
    public void addFirst(T val) {
        Noeud n = new Noeud(val);
        if (isEmpty()) {
            first = last = n;
        } else {
            n.next = first;  // Lien du nouveau nœud à l'ancien premier
            first.prev = n;
            first = n;       // Redéfinir le premier nœud
        }
    }

    @Override
    public void addLast(T val) {
        Noeud n = new Noeud(val);
        if (isEmpty()) {
            first = last = n;
        } else {
            last.next = n;      // Lien du nouveau nœud à l'ancien dernier
            n.prev = last;
            last = n;           // Redéfinir le dernier nœud
        }
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("File doublement chainée vide");
        }
        T data = (T) first.data;
        first = first.next;
        if (first != null) {
            first.prev = null;
        } else {
            last = null;      // Si la liste devient vide après suppression
        }
        return data;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("File doublement chainée vide");
        }
        T data = (T) last.data;
        last = last.prev;
        if (last != null) {
            last.next = null;
        } else {
            first = null;     // Si la liste devient vide après suppression
        }
        return data;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

}
