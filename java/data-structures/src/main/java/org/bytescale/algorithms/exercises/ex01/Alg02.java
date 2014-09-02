package org.bytescale.algorithms.exercises.ex01;

/**
 * Created by Jared on 8/30/14.
 */
public class Alg02 {
    //Give the type and value of each of the following expressions
    public static void main(String[] args) {
        //(1+2.236)/2 should be a float
        Object result1 = (1+2.236)/2;
        System.out.println("(1+2.236)/2 is a " + result1.getClass().getName()); //Actually a double
        //1+2+3+4.0 should be a double
        Object result2 = (1+2+3+4.0);
        System.out.println("1+2+3+4.0 is a " + result2.getClass().getName()); //Confirmed a double
        //4.1 >= 4 should be a boolean
        Object result3 = 4.1 >= 4;
        System.out.println("4.1 >= 4 is a " + result3.getClass().getName()); //Confirmed a boolean
        //1+2+"3" should not work (cast exception)
        Object result4 = 1+2+"3";
        System.out.println("1+2+\"3\" is a " + result4.getClass().getName()); //Actually a String
    }

}
