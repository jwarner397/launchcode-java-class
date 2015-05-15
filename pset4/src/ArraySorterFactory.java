import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Joseph on 5/15/2015.
 */
public class ArraySorterFactory {




    public static SortStrategy getBubble(String[] array){
        return new BubbleSort(array);
    }

    public static SortStrategy getInsetion(String[] array){
        return new InsertionSort(array);
    }

    public static SortStrategy getMerge(String[] array){
        return new MergeSort(array);
    }

    public static String[] assembleArray(int length) {

        // initiate arrays for text file and sortable array and counter to establish random number range
        ArrayList<String> dictionary = new ArrayList<String>();
        String[] array = new String[length];
        int count = 0;

        // open text file and read into ArrayList
        try {
            File file = new File("C:/Users/Joseph/IdeaProjects/launchcode-java-class/pset4/src/large.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String word = sc.nextLine();
                dictionary.add(word);
                count++;
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        // build and return sorter array based on random indexes in text file
        Random rand = new Random();
        if (dictionary.get(0) != null) {
            for (int i = 0; i < length; i++) {
                int randomNum = rand.nextInt(count);
                array[i] = dictionary.get(Math.abs(randomNum));
            }
        }
        return array;
    }

}





