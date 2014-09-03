package org.bytescale.algorithms.exercises.ex01;

public class Alg16 {
    public static void main(String[] args) {
        //What does this code print out?
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
    }
}
/*
 * I believe this turns out to be the Fibonacci Sequence:
 * When i is:       f is:
 * 0                1
 * 1                1
 * 2                2
 * 3                3
 * 4                5
 * 5                8
 * 6                13
 * 7                21
 * 8                34
 * 9                55
 * 10               89
 * 11               144
 * 12               233
 * 13               377
 * 14               610
 * 15               987
 */
