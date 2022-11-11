import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        if (args.length < 3) {
            System.out.println("ERROR! Three arguments are required! \nPlease enter the input's file classpath as the first command line argument, the output's file classpath as  the second command line argument and the value of N as the third command line argument!");
            System.exit(1);
        } else if (args.length > 3) {
            System.out.println("ERROR! Too much arguments! \nThree arguments are required! \nPlease enter the input's file classpath as the first command line argument, the output's file classpath as  the second command line argument and the value of N as the third command line argument!");
            System.exit(1);
        } else {
            System.out.println("Reading input's classpath... ");
            List<String> inputFile = FileManager.readInputClasspath(args[0]);

            System.out.println("Reading output's classpath... ");
            FileWriter outputFile = FileManager.readOutputClasspath(args[1]);

            System.out.println("Reading the value of N...");
            int valueOfN = Utilities.readValueOfN(args[2]);

            System.out.println("Getting ready for process of reflection... \n");
            Process.processReflection(inputFile, outputFile, valueOfN);
            System.out.println("Reflection process finished successfully!");
            System.exit(0);
        }
    }
}