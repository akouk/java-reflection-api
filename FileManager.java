import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public static List readInputClasspath(String args) {
        System.out.println("Reading from file: \"" + args + "\"");
        
        Scanner inputReadFromFile = scanInputFile(args);

        List<String> l = new ArrayList();
        while (inputReadFromFile.hasNextLine()) {
            String line = inputReadFromFile.nextLine();
            l.add(line);
        }
        inputReadFromFile.close();
        System.out.println("Reading done! \n");
        return l;
    }

    private static Scanner scanInputFile(String args) {
        Scanner inputReadFromFile = null;
        File inputFile = new File(String.valueOf(args));
        try {
            inputReadFromFile = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR! File not found for \"" + args + "\"");
            System.exit(1);
        }
        return inputReadFromFile;
    }

    public static FileWriter readOutputClasspath(String args) {
        FileWriter outputC = null;
        try {
            outputC = new FileWriter(String.valueOf(args));
            System.out.println("Reading done! \n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return outputC;
    }

    public static void fileWriting(FileWriter cp, StringBuilder strBuilder) {
        System.out.println("Creating the output file to given classpath...");
        PrintWriter outputFile = new PrintWriter(new BufferedWriter(cp));
        System.out.println("File created!");
        System.out.println("Writing to output file...");
        outputFile.println(strBuilder);
        System.out.println("Writing done!! \n");

        outputFile.close();
    }
}