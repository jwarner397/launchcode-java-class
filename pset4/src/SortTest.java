import org.junit.Test;

import junit.framework.TestCase;


/**
 * Created by Joseph on 5/14/2015.
 */
public class SortTest extends TestCase {
        @Test
        public void testrraySorters() {
            String[] aArray = {"jar", "candy", "desk", "fan", "floor", "ceiling", "bar", "beer", "laptop"};
            long startTimeBS = System.nanoTime();
            BubbleSort a = new BubbleSort(aArray);
            long endTimeBS = System.nanoTime();
            long startTimeIS = System.nanoTime();
            InsertionSort b = new InsertionSort(aArray);
            long endTimeIS = System.nanoTime();
            long startTimeMS = System.nanoTime();
            MergeSort c = new MergeSort(aArray);
            // System.out.println("This is the unsorted array");
            // c.printArray();
            // System.out.println("Now it's sorted!");
            // c.sortUnsortedArray();





        }
}


