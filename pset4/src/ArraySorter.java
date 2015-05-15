import java.util.List;

/**
 * Created by Joseph on 5/13/2015.
 */
public class ArraySorter {

    // passes object through interface to sorter methods, returns sorted array
    public static String[] sortUnsortedArray(SortStrategy a){
        return a.sortArray();
    }

    // prints an array of strings
    public static void printArray(String[] array){
        int length = array.length;
        for (int i = 0; i < length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        String[] aArray = {"jar", "candy", "desk", "fan", "floor", "ceiling", "bar", "beer", "laptop"};
        long startTimeBS = System.nanoTime();
        BubbleSort a = new BubbleSort(aArray);
        long endTimeBS = System.nanoTime();
        long startTimeIS = System.nanoTime();
        InsertionSort b = new InsertionSort(aArray);
        long endTimeIS = System.nanoTime();
        long startTimeMS = System.nanoTime();
        MergeSort c = new MergeSort(aArray);
        long endTimeMS = System.nanoTime();
        System.out.println("Bubble Sort took " + (endTimeBS - startTimeBS) + " nanoseconds.");
        System.out.println("Insertion Sort took "+ (endTimeIS - startTimeIS) + " nanoseconds.");
        System.out.println("Merge Sort took "+ (endTimeMS - startTimeMS) + " nanoseconds.");
        // System.out.println("This is the unsorted array");
        // printArray(aArray);
        // System.out.println("Now it's sorted!");
        printArray(sortUnsortedArray(c));


    }


}
