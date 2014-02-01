package org.bytescale.datastructures.tests.util;

import java.io.*;
import java.util.Scanner;

public class UnionFindTestDataReader {
    private File testDataFile;
    private Scanner scanner;

    public UnionFindTestDataReader(String testFile) throws FileNotFoundException {
        testDataFile = new File(testFile);
        try {
            scanner = new Scanner(new FileInputStream(testDataFile), "UTF-8");
        } catch (FileNotFoundException e) {
            System.out.println("Could not determine that the path to testFile was valid. Unable to open file for reading.");
            throw e;
        }
    }

    public boolean isEmpty() {
        return !scanner.hasNext();
    }

    public int readInt() {
        return scanner.nextInt();
    }

}
