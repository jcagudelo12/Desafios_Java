import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.*;

/**
 * GeneradorBoletoSimple
 */
public class GeneradorBoletoSimple {

    private static int MIN = 1;
    private static int MAX = 50;
    private static int NUMS = 5;

    public static List<Integer> generaBoleto() {
        List<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < NUMS; i++) {
            int numero = generaNumero();
            while(numeros.contains(numero)){
                numero = generaNumero();
            }
            numeros.add(numero);
        }

        Collections.sort(numeros);
        return numeros;        
    }

    private static int generaNumero() {
        return (int) (Math.random() * (MAX - MIN + 1)) + MIN;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            List<Integer> boleto = generaBoleto();
            System.out.println(boleto.toString());            
        }
    }
}