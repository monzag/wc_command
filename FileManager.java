import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class FileManager {

    private ArrayList<String[]> linesList = new ArrayList<>();

    public ArrayList<String[]> loadDataFromFile(String fileName) {
        Scanner read = null;

        try {
            read = new Scanner(new File(fileName));
        }

        catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }

        while (read.hasNextLine()) {
            String data = read.nextLine();
            String[] line = data.split("\\s");
            linesList.add(line);
        }
        read.close();

        return linesList;
    }

    public Integer countLines() {
        Integer amountOfLines = 0;

        for (String[] array : linesList) {
            amountOfLines++;
        }

        return amountOfLines;
    }

    public Integer countWords() {
        Integer amountOfWords = 0;

        for (String[] array : linesList) {
            for (String word : array) {
                 amountOfWords++;
            }
        }
        return amountOfWords;
    }

    public Long countBytes(String filename) {
        File file = new File(filename);
        Long bytes = file.length();

        return bytes;
    }
}