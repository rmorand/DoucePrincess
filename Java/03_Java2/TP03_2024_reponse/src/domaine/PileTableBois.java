package domaine;

public class PileTableBois implements Pile<TableBois> {
    private TableBois[] tables;
    private int size = 0;

    public PileTableBois() {
        tables = new TableBois[5];
    }

    @Override
    public void push(TableBois val) {
        if (size >= tables.length) {
            resize();
        }
        tables[size++] = val;
    }

    @Override
    public TableBois pop() {
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
        TableBois[] newTab = new TableBois[tables.length * 2];
        for (int i = 0; i < tables.length; i++) {
            newTab[i] = tables[i];
        }
        tables = newTab;
    }

    public Integer surfaceTotale() {
        int surface = 0;

        for (int i = 0; i < size; i++) {
            surface += ((Table)tables[i]).surface();
        }

        return surface;
    }
}
