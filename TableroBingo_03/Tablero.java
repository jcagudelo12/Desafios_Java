package TableroBingo_03;

import java.util.*;

public class Tablero {
    private List<ColumnaBingo> columnas = new ArrayList<>();

    public Tablero(){
        for (LetraBingo letra : LetraBingo.values()) {
            columnas.add(new ColumnaBingo(letra));
        }
    }

    @Override
    public String toString(){
        String s = "";
        for (ColumnaBingo columnaBingo : columnas) {
            s += columnaBingo.toString() + "\n";
        }
        return s;
    }
}
