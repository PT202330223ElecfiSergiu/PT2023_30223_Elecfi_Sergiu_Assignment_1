package Operatii;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operatii {

    public Map<Integer, Float> conversion(String x) {
        Map<Integer, Float> aux = new HashMap<>();
        Pattern pattern = Pattern.compile("([+-]?\\d*)[xX](\\^(\\d+))?|([+-]?\\d+)");
        Matcher matcher = pattern.matcher(x);
        while(matcher.find()) {
            if(matcher.group(4) != null) {
                float coef = Float.parseFloat(matcher.group(4));
                aux.put(0,coef);
            }
            else {
                if(matcher.group(1).equals("-") || matcher.group(1).equals("")) {
                    if(matcher.group(1).equals("-")) {
                        if(matcher.group(2) == null) {
                            aux.put(1, (float) -1);
                        }
                        else {
                            int exp = Integer.parseInt(matcher.group(3));
                            aux.put(exp, (float) -1);
                        }
                    }
                    else {
                        if(matcher.group(2) == null) {
                            aux.put(1, (float) 1);
                        }
                        else {
                            int exp = Integer.parseInt(matcher.group(3));
                            aux.put(exp, (float) 1);
                        }
                    }
                }
                else {
                    try {
                        if(matcher.group(2) == null) {
                            float coef = Float.parseFloat(matcher.group(1));
                            aux.put(1, coef);
                        }
                        else {
                            int exp = Integer.parseInt(matcher.group(3));
                            float coef = Float.parseFloat(matcher.group(1));
                            aux.put(exp, coef);
                        }
                    }catch (NumberFormatException e1) {
                        int exp = Integer.parseInt(matcher.group(3));
                        aux.put(exp, (float) 1);
                    }
                }
            }
        }
        return aux;
    }

    public Map<Integer, Float> adunare(Map<Integer, Float> aux1, Map<Integer, Float> aux2){
        Map<Integer, Float> suma = new HashMap<>();
        for (Map.Entry<Integer, Float> a : aux1.entrySet()) {
            int expo = a.getKey();
            float coef = a.getValue();
            suma.put(expo, coef);
        }

        for (Map.Entry<Integer, Float> a : aux2.entrySet()) {
            int expo = a.getKey();
            float coef = a.getValue();
            if (suma.containsKey(expo)) {
                suma.put(expo, suma.get(expo) + coef);
            } else {
                suma.put(expo, coef);
            }
        }
        return suma;
    }

    public Map<Integer, Float> scadere(Map<Integer, Float> aux1, Map<Integer, Float> aux2){
        Map<Integer, Float> diferenta = new HashMap<>();

        for (Map.Entry<Integer, Float> a : aux1.entrySet()) {
            int expo = a.getKey();
            float coef = a.getValue();
            diferenta.put(expo, coef);
        }

        for (Map.Entry<Integer, Float> a : aux2.entrySet()) {
            int expo = a.getKey();
            float coef = a.getValue();
            if (diferenta.containsKey(expo)) {
                diferenta.put(expo, diferenta.get(expo) - coef);
            } else {
                diferenta.put(expo, -coef);
            }
        }

        return diferenta;
    }

    public Map<Integer, Float> inmultire(Map<Integer, Float> aux1, Map<Integer, Float> aux2){
        Map<Integer, Float> produs = new HashMap<>();
        for (Map.Entry<Integer, Float> a : aux1.entrySet()) {
            int exp1 = a.getKey();
            float coef1 = a.getValue();

            for (Map.Entry<Integer, Float> b : aux2.entrySet()) {
                int exp2 = b.getKey();
                float coef2 = b.getValue();

                int exp = exp1 + exp2;
                float coef = coef1 * coef2;

                if (produs.containsKey(exp)) {
                    produs.put(exp, produs.get(exp) + coef);
                } else {
                    produs.put(exp, coef);
                }
            }
        }
        return produs;
    }

    public String afisarePolinom(SortedMap<Integer, Float> aux) {
        String x = "";
        for(Entry<Integer, Float> a : aux.entrySet()) {
            int exp = a.getKey();
            float coef = a.getValue();
            Polinom p = new Polinom(exp,coef);
            if(coef != 0) {
                if(coef  < 0 ) {
                    x = x + "-";
                }
                else if(x != "") {
                    x = x + "+";
                }
                x = x + p.toString();
            }
        }
        return x;
    }
}