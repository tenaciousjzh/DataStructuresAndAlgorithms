package org.bytescale.algorithms.transformations;

/**
 * Created by Jared on 8/22/14.
 */
public class PositiveIntToBinaryString {
    public static String convert(int N) {
        if (N < 0) return "NA";
        String S = "";
        for (int n = N; n > 0; n /= 2) {
            int rem = n % 2;
            S = rem + S;
        }
        return S;
    }
}
