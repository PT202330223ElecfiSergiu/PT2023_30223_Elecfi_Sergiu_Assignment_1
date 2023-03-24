package org.example;

public class Polinom {

    public float exponent;
    public float coeficient;

    public Polinom(float exponent, float coeficient){
        this.exponent = exponent;
        this.coeficient = coeficient;
    }

    public void setExponent(float exponent) {
        this.exponent = exponent;
    }

    public void setCoeficient(float coeficient){
        this.coeficient = coeficient;
    }

    public float getExponent(){
        return this.exponent;
    }

    public float getCoeficient(){
        return this.coeficient;
    }

    public String toString(){
        String x;
        switch ((int) exponent){ //verificam daca puterea lui x
            case 0: //in cazul in care puterea este 0
                x = String.valueOf(coeficient);
                return x;
            case 1: //in cazul in care puterea este 1
                switch ((int) coeficient){//verificam coeficientul, daca este 1 sau -1 nu mai scrie 1 in fata la x
                    case 1:
                        x = "x";
                        return x;
                    case -1:
                        x = "-x";
                        return x;
                    default:
                        x = String.valueOf(coeficient) + "x";
                        return x;
                }
            default: //in cazul in care x > 1
                switch((int) coeficient) {
                    case 1:
                        x = "x^" + String.valueOf(exponent);
                        return x;
                    case -1:
                        x = "-x^" + String.valueOf(exponent);
                        return x;
                    default:
                        x = String.valueOf(coeficient) + "x^" + String.valueOf(exponent);
                        return x;
                }
        }
    }
}
