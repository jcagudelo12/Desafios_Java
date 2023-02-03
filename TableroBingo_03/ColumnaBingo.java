package TableroBingo_03;

import java.util.*;

public class ColumnaBingo {
    private LetraBingo letra;
    private int[] nums;
    
    public ColumnaBingo(LetraBingo letra){
        this.letra = letra;
        this.nums = generarColumna(letra);
    }

    public int[] generarColumna(LetraBingo letra) {
        List<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < letra.getLon(); i++) {
            if (letra.getLetra() == "N" && i == 2) {
                System.out.println(letra.getLetra());
                numeros.add(0);
            }
            else{
                int numero = generarNumero(letra.getMin(), letra.getMax());
                while(numeros.contains(numero)){
                    numero = generarNumero(letra.getMin(), letra.getMax());
                }
                numeros.add(numero);
            }
        }

        //Collections.sort(numeros);
        return numeros.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int generarNumero(int min, int max) {
        return (int) (Math.random() * (min - max + 1)) + max;
    }

    @Override
    public String toString(){
        return letra.getLetra() + ": " + Arrays.toString(nums);
    }
}
