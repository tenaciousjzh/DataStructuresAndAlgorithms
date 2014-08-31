package org.bytescale.algorithms.exercises;

/**
 * Created by Jared on 8/30/14.
 */
public class AlgEx0111 {
    public static void main(String[] args) {
        //Expression evaluation
        //(0+15)/2 should equal 7
        System.out.println("(0 + 15)/2 = " + ((0+15)/2)); // Confirmed 7
        //2.0e-6 * 100000000.1 should equal ~200
        System.out.println("2.0e-6 * 100000000.1 = " + (2.0e-6 * 100000000.1));
        //true && false || true && true should equal (false || true) == true
        System.out.println("true && false || true && true = " + (true && false || true && true));
    }
}
