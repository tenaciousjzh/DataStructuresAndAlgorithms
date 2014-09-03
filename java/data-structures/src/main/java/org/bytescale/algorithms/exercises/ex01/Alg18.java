package org.bytescale.algorithms.exercises.ex01;

/**
 * Determine the value of the following code fragments
 */
public class Alg18 {
    public static void main(String[] args) {
        double t = 9.0;
        while (Math.abs(t - 9.0/t) > 0.001) {
            t = (9.0/t + t) / 2.0;
            System.out.println("t = " + t);
        }
        String outcome = String.format("%.5f", t);
        System.out.println(outcome);
    }
}
