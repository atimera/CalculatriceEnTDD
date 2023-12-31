package com.atimera.calculatrice;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class Calculatrice {
    Logger logger = Logger.getLogger("Calculatrice");

    public int ajouter(int x, int y) {
        return x+y;
    }
    public int soustraire(int x, int y) {
        logger.info("=== Soustraction ===");
        return x-y;
    }
    public int diviser(int x, int y) {
        logger.info("=== Division ===");
        return x /y;
    }

    public int multiplier(int x, int y) {
        logger.info("=== Multiplication ===");
        return x*y;
    }

    public Set<Integer> digitsSet(int number) {
        logger.info("=== DigitSet ===");
        String[] strNumer = String.valueOf(number).split("");
        Set<Integer> integerSet = new HashSet<>();
        for(String n : strNumer){
            if(!n.equals("-")) {
                integerSet.add(Integer.valueOf(n));
            }
        }
        return integerSet;
    }
}
