import java.util.*;

public class Boleto {
    private int[] numeros;
    private int reintegro;

    private static int MIN = 1;
    private static int MAX = 50;
    private static int MIN_REINTEGRO = 1;
    private static int MAX_REINTEGRO = 10;
    private static int NUMS = 6;

    public Boleto(){
        numeros = generarBoleto(MIN, MAX, NUMS);
        reintegro = generarReintegro(MIN_REINTEGRO, MAX_REINTEGRO);
    }

    public int[] generarBoleto(Integer MIN_N, Integer MAX_N, Integer Nums) {
        List<Integer> boleto = new ArrayList<>();
        for (int i = 0; i < NUMS; i++) {
            int numero = generarNumero(MIN_N, MAX_N);
            while(boleto.contains(numero)){
                numero = generarNumero(MIN_N, MAX_N);
            }
            boleto.add(numero);
        }

        Collections.sort(boleto);
        return boleto.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int generarNumero(Integer MIN_N, Integer MAX_N) {
        return (int) (Math.random() * (MAX_N - MIN_N + 1)) + MIN_N;
    }

    private static int generarReintegro(Integer MIN_R, Integer MAX_R) {
        return (int) (Math.random() * (MAX_R - MIN_R + 1)) + MIN_R;
    }

    @Override
    public String toString(){
        return "N: " + Arrays.toString(numeros) + " R: " + reintegro;
    }
}
