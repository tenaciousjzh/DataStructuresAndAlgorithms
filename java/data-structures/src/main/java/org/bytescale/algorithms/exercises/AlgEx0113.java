package org.bytescale.algorithms.exercises;

import java.io.IOException;
import java.util.Scanner;

/**
 * 1.1.3 - Write a program that takes three integer command-line arguments and prints equal if all
 * three are equal, and not equal otherwise.
 */
public class AlgEx0113 {

   public static void main(String[] args) throws IOException {
       System.out.println("Enter 3 integers and the program will tell you if all three are equal.");
       String newline = System.getProperty("line.separator");
       int[] vals = new int[3];
       Scanner in = new Scanner(System.in);
       for (int i = 0; i < 3; i++) {
           System.out.print("Please provide integer " + (i+1) +" : ");
           vals[i] = in.nextInt();
           System.out.print(newline);
       }
       String equality = (vals[0] == vals[1]) && (vals[1] == vals[2])  ? "equal" : "not equal";
       System.out.println(equality);
   }
}
