package org.bytescale.algorithms.exercises.ex01;

import java.util.Scanner;

/**
 * Write a code fragment that prints true if the double variables x and y are both strictly
 * between 0 and 1 and false otherwise.
 * Sedgewick, Robert; Wayne, Kevin (2011-02-21). Algorithms (4th Edition) (Kindle Locations 1276-1278). Pearson Education. Kindle Edition.
 */
public class Alg05 {
    public static void main(String[] args) {
        System.out.println("Enter 2 doubles and the program will tell you if they are strictly between 0 and 1.");
        String newline = System.getProperty("line.separator");
        double x = 0;
        double y = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Please provide a double value for x: ");
        x = in.nextDouble();
        System.out.print(newline);
        System.out.print("Please provide a double value for y: ");
        y = in.nextDouble();
        System.out.print(newline);
        if (isInRange(x, 0, 1) && isInRange(y, 0, 1)) {
            System.out.println("true");
        }  else {
            System.out.println("false");
        }



    }

    public static boolean isInRange(double val, double lowerBound, double upperBound) {
        return (lowerBound < val && val < upperBound);
    }
}
