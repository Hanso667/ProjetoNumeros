package br.ulbra.bonus;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class Numero {

    ArrayList<Double> numero = new ArrayList();
    ArrayList<Double> pares = new ArrayList();
    ArrayList<Double> impares = new ArrayList();

    public void addNumero(double a) {
        numero.add(a);
        if (a % 2 == 0) {
            pares.add(a);
        } else if (a % 2 != 0) {
            impares.add(a);
        }
    }

    public void removeNumero(double a) {
        numero.remove(numero.indexOf(a));
        if (a % 2 == 0) {
            pares.remove(pares.indexOf(a));
        } else if (a % 2 != 0) {
            impares.remove(impares.indexOf(a));
        }
    }

    public void setNumero(double antigo, double novo) {
        numero.set(numero.indexOf(antigo), novo);
        if (pares.contains(antigo) && novo % 2 == 0) {
            pares.set(pares.indexOf(antigo), novo);
        } else if (pares.contains(antigo) && novo % 2 != 0) {
            pares.remove(pares.indexOf(antigo));
            impares.add(novo);
            
        } else if (impares.contains(antigo) && novo%2 != 0) {
            impares.set(impares.indexOf(antigo), novo);
        } else if (impares.contains(antigo) && novo%2 == 0) {
            impares.remove(impares.indexOf(antigo));
            pares.add(novo);
        }
    }

    public String getNumero() {
        String lista = "Lista:\n";
        for (int i = 0; i < numero.size(); i++) {
            lista += i + " - " + numero.get(i) + "\n";
        }
        return lista;
    }

    public String getNumeroPares() {
        String lista = "\nLista Pares:\n";
        for (int i = 0; i < pares.size(); i++) {
            lista += pares.get(i) + "\n";
        }
        return lista;
    }

    public String getNumeroImpares() {
        String lista = "\nLista Impares:\n";
        for (int i = 0; i < impares.size(); i++) {
            lista += impares.get(i) + "\n";
        }
        return lista;
    }

    public String getMedia() {
        double numeros = 0;
        for (int i = 0; i < numero.size(); i++) {
            numeros += numero.get(i);
        }
        return "\nMedia: " + numeros / numero.size() + "\n";
    }

    public String getMinMax() {
        double min = numero.get(0);
        double max = numero.get(0);
        for (int i = 0; i < numero.size(); i++) {
            if (numero.get(i) > max) {
                max = numero.get(i);
            }
        }
        return "\nMax: " + max + "\n" + "Min: " + min;
    }

    public void sortNumeros() {
        Collections.sort(numero);
        Collections.sort(impares);
        Collections.sort(pares);
    }

    public String getSpecifiedNumero(double numero) {
        if (this.numero.contains(numero)) {
            return this.numero.indexOf(numero) + " - " + this.numero.get(this.numero.indexOf(numero));
        }
        return null;
    }

    public boolean isEmptyList() {
        return numero.isEmpty();
    }

    public boolean isContained(double a) {
        return numero.contains(a);
    }
}
