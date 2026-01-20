package structures.maps;

import java.util.*;

public class EjerciciosMapas {

    public static void frecuenciaElementos(List<Integer> lista) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int n : lista) {
            map.merge(n, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " → " + e.getValue());
        }
    }

    public static void primerNoRepetido(List<Integer> lista) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int n : lista) {
            map.merge(n, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                System.out.println(e.getKey());
                return;
            }
        }
    }

    public static void rankingJugadores(Map<String, Integer> jugadores) {
        Map<String, Integer> mejores = new HashMap<>();
        for (Map.Entry<String, Integer> e : jugadores.entrySet()) {
            mejores.merge(e.getKey(), e.getValue(), Math::max);
        }

        Map<Integer, List<String>> ranking = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, Integer> e : mejores.entrySet()) {
            ranking.computeIfAbsent(e.getValue(), k -> new ArrayList<>()).add(e.getKey());
        }

        for (Map.Entry<Integer, List<String>> e : ranking.entrySet()) {
            for (String nombre : e.getValue()) {
                System.out.println(nombre + " → " + e.getKey());
            }
        }
    }

    public static void maximoPorCarrera(Map<String, Integer> datos) {
        Map<String, Integer> max = new HashMap<>();
        for (Map.Entry<String, Integer> e : datos.entrySet()) {
            String carrera = e.getKey().split("-")[0];
            max.merge(carrera, e.getValue(), Math::max);
        }
        for (Map.Entry<String, Integer> e : max.entrySet()) {
            System.out.println(e.getKey() + " → " + e.getValue());
        }
    }
}
