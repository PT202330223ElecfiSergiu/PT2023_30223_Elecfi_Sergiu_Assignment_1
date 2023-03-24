package org.example;

import java.util.HashMap;
import java.util.Map;

public class Operatii {

    public Map<Integer, Integer> conversion(String x) {
        Map<Integer, Integer> aux = new HashMap<>();
        // Separăm fiecare termen și coeficientul corespunzător din string
        String[] terms = x.split(" \\+ ");
        for (String term : terms) {
            String[] parts = term.split("x\\^");
            int coeff = Integer.parseInt(parts[0]);
            int expo = parts.length > 1 ? Integer.parseInt(parts[1]) : 0;
            aux.put(expo, coeff);
        }
        return aux;
    }

    public Map<Integer, Integer> adunare(Map<Integer, Integer> aux1, Map<Integer, Integer> aux2){
        Map<Integer, Integer> suma = new HashMap<>();
        for (Map.Entry<Integer, Integer> term : aux1.entrySet()) {
            int expo = term.getKey();
            int coef = term.getValue();
            suma.put(expo, coef);
        }

        for (Map.Entry<Integer, Integer> term : aux2.entrySet()) {
            int expo = term.getKey();
            int coef = term.getValue();
            if (suma.containsKey(expo)) {
                suma.put(expo, suma.get(coef) + coef);
            } else {
                suma.put(expo, coef);
            }
        }
        return suma;
    }

    public Map<Integer, Integer> scadere(Map<Integer, Integer> aux1, Map<Integer, Integer> aux2){
        Map<Integer, Integer> diferenta = new HashMap<>();

        for (Map.Entry<Integer, Integer> term : aux1.entrySet()) {
            int expo = term.getKey();
            int coef = term.getValue();
            diferenta.put(expo, coef);
        }

        for (Map.Entry<Integer, Integer> term : aux2.entrySet()) {
            int expo = term.getKey();
            int coef = term.getValue();
            if (diferenta.containsKey(expo)) {
                diferenta.put(expo, diferenta.get(expo) - coef);
            } else {
                diferenta.put(expo, -coef);
            }
        }

        return diferenta;
    }

    public Map<Integer, Integer> inmultire(Map<Integer, Integer> aux1, Map<Integer, Integer> aux2){
        Map<Integer, Integer> produs = new HashMap<>();
        for (Map.Entry<Integer, Integer> term1 : aux1.entrySet()) {
            int exp1 = term1.getKey();
            int coef1 = term1.getValue();

            for (Map.Entry<Integer, Integer> term2 : aux2.entrySet()) {
                int exp2 = term2.getKey();
                int coef2 = term2.getValue();

                int exp = exp1 + exp2;
                int coef = coef1 * coef2;

                if (produs.containsKey(exp)) {
                    produs.put(exp, produs.get(exp) + coef);
                } else {
                    produs.put(exp, coef);
                }
            }
        }
        return produs;
    }
}

