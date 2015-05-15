/**
 * Created by Joseph on 5/13/2015.
 */
public class BubbleSort implements SortStrategy {

    private String[] array;

    public BubbleSort(String[] array) {
        this.array = array;
    }

    public String[] getArray() {
        return this.array;
    }

    // sorts with Bubble Sort method and returns sorted array
    public String[] sortArray() {
        // Sorts array via bubble sort
        // Declaration of temporary variable needed to switch two values
        String temp;
        int length = this.array.length;
        // Nested loop to sort the array
        for (int j = 0; j < length; j++){
                for (int i = 1; i < (length); i++) {
                    // Compares two values and switches them if out of order
                    try {
                        if (this.array[i - 1].compareTo(array[i]) > 0) {
                            temp = this.array[i - 1];
                            this.array[i - 1] = this.array[i];
                            this.array[i] = temp;
                        }
                    } catch(ArrayIndexOutOfBoundsException e){
                        System.out.print("Your array crashed!");
                        String[] nullArray = new String[]{};
                        return nullArray;
                    }
                }
            }
            return this.array;
    }
}
