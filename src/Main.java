// import necessary packages and classes
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

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

    public static int rotate(String line, int position) {
        String direction = line.substring(0,1);
        String stringCount =  line.substring(1);
        int count = Integer.parseInt(stringCount);
        if(direction.equals("R")) {
            position = position + count;
        }
        if(direction.equals("L")) {
            position = position - count;
        }
        while (position > 99) {
            position = position - 100;
        }
        while (position < -99) {
            position = position + 100;
        }
        return position;
    }

    public static List<Integer> rotateV2(String line, int position, int zeroCount) {
        String direction = line.substring(0,1);
        String stringCount =  line.substring(1);
        int count = Integer.parseInt(stringCount);
        if (position == 100) {
            position = 0;
        }
        int oldPosition = position;

        if(direction.equals("R")) {

            while ((position + count ) > 99) {
                zeroCount = zeroPlus(zeroCount);
//                System.out.println("\t ZeroLeap because the result is >99 while rotating right");
                position = position - 100;
            }
//            if (( oldCount != 0 ) && (( position + count ) <= 0 )) {
//                zeroCount = zeroPlus(zeroCount);
//            }

            position = position + count;

        }

        if(direction.equals("L")) {
            boolean bigLeap = false;

            while ((position - count ) <= 0) {
                // skip one count if oldPosition was already "0"
                if ((oldPosition == 0) && !bigLeap ) {
                    position = position + 100;
                    bigLeap = true;
                    continue;
                }
                zeroCount = zeroPlus(zeroCount);
//                System.out.println("\t ZeroLeap because the result is < 0 while rotating left");
                position = position + 100;
            }
//            if (( oldCount != 0 ) && (( position - count ) >= 0 )) {
//                zeroCount = zeroPlus(zeroCount);
//            }

            position = position - count;

        }
        return Arrays.asList(position,zeroCount);
    }

    public static int zeroPlus(int zeroCount) {
        zeroCount = zeroCount + 1;
        //System.out.println("ZeroLeap");
        return zeroCount;
    }
    public static void main(String[] args)
        throws IOException
// V1:
//    {
//        int position = 50;
//        int zeroCount = 0;
//        int iteration = 1;
//        for (String line : readFile("src/data/input")) {
//            position = rotate(line, position);
//            if(position == 0) {
//                zeroCount++;
//            }
//            System.out.println(iteration + "\t: " + position);
//            iteration++;
//
//        }
//        System.out.println("zeroCount: " + zeroCount);
//
//    }

// V2:
    {
        int position = 50;
        int zeroCount = 0;
        int iteration = 1;
        System.out.println("0\t: " + position + "\t\t\t\t\t\t\t ZeroCount \t:" + zeroCount);
        for (String line : readFile("src/data/day01/input")) {
//        for (String line : readFile("src/data/day01/input_sample")) {
            List<Integer> listFromRotateV2 = rotateV2(line, position, zeroCount);
            position = listFromRotateV2.get(0);
            zeroCount = listFromRotateV2.get(1);
//            if(position == 0) {
//                zeroCount++;
//            }
            System.out.println(iteration + "\t: " + position + " \t rotated by \t: " + line + "  \t ZeroCount \t:" + zeroCount);
            iteration++;

        }
        System.out.println("zeroCount: " + zeroCount);
    // Expected result for part 2 is: 5872
    }
}
