package com.atimera.calculatrice;

import java.util.HashSet;
import java.util.Set;

public class Calculatrice {
    public int ajouter(int x, int y) {
        return x+y;
    }
    public int soustraire(int x, int y) {
        return x-y;
    }
    public int diviser(int x, int y) {
        return x /y;
    }

    public int multiplier(int x, int y) {
        return x*y;
    }

    public Set<Integer> digitsSet(int number) {
        String[] strNumer = String.valueOf(number).split("");
        Set<Integer> integerSet = new HashSet<>();
        for(String n : strNumer){
            if(!n.equals("-")) {
                integerSet.add(Integer.valueOf(n));
            }
        }
        System.out.println(integerSet);
        return integerSet;
    }
}
