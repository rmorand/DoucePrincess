package domaine;

public class PileTable implements Pile<Table> {
    private Table[] tables;
    private int size = 0;

    public PileTable() {
        tables = new Table[5];
    }

    @Override
    public void push(Table val) {
        if (size >= tables.length) {
            resize();
        }
        tables[size++] = val;
    }

    @Override
    public Table pop() {
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

    private void resize() {
        Table[] newTab = new Table[tables.length * 2];
        for (int i = 0; i < tables.length; i++) {
            newTab[i] = tables[i];
        }
        tables = newTab;
    }

    public Integer surfaceTotale() {
        int surface = 0;

        for (int i = 0; i < size; i++) {
            surface += tables[i].surface();
        }

        return surface;
    }
}
