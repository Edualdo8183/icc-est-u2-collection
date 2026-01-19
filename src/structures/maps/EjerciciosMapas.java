package structures.maps;


import java.util.*;

public class EjerciciosMapas {

    
    public static void frecuenciaElementos(List<Integer> lista) {

        Map<Integer, Integer> frecuencia = new TreeMap<>();

        for (int n : lista) {
            frecuencia.put(n, frecuencia.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : frecuencia.entrySet()) {
            System.out.println(e.getKey() + " → " + e.getValue());
        }
    }

   
    public static void primerNoRepetido(List<Integer> lista) {

        Map<Integer, Integer> contador = new LinkedHashMap<>();

        for (int n : lista) {
            contador.put(n, contador.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : contador.entrySet()) {
            if (e.getValue() == 1) {
                System.out.println(e.getKey());
                return;
            }
        }
    }
}

        
