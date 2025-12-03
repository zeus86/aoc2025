// import necessary packages and classes
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day02 {
    public static String[] readFile(String inputFile)
            throws IOException
    {
        List<String> listOfStrings = new ArrayList<String>();

        // load the data from file
        listOfStrings = Files.readAllLines(Paths.get(inputFile));

        // convert arraylist to inputLines
        String[] inputLines = listOfStrings.toArray(new String[0]);

        return inputLines;

    }

    public static void main(String[] args)
            throws IOException
        int part = 1;
        {
            if (part == 1) {
            // V1:
            for (String line : readFile("src/data/input_sample")) {
                System.out.println("Line is \t: " + line);
            }
        }

            if (part == 2) {
// V2:
                {
                    // V2
                }
            }
    }
}
