package domaine;

public class PileTable<T> implements Pile{
    private Table[] tables;
    Integer surfaceTotale;
    Integer size;

    public PileTable(Integer surfaceTotale, Integer size) {
        this.surfaceTotale = surfaceTotale;
        this.size = 0;
        tables = new Table[5];
    }

    @Override
    public void push(Object val) {
        if(size>= tables.length) {
            resize();
        }
        tables[size++] = val;
    }

    @Override
    public Object pop() {
        return tables[--size];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public void resize() {
        Table[] newTab = tables.length * 2;
        for (int i=0; i<tables.length; i++) {
            newTab[i] = tables[i];
        }
        tables = newTab;
    }

    private Integer surfaceTotale() {
        return 0;
    }
}
