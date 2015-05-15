/**
 * Created by Joseph on 5/14/2015.
 */
public class InsertionSort implements SortStrategy {

    private String[] array;

    public InsertionSort(String[] array) {
        this.array = array;
    }

    // SortStrategy method to sort array
    // sorts with Insertion Sort method and returns sorted array
    @Override
    public String[] sortArray() {
        int t;
        int length = this.array.length;
        String temp;

        try {
            for (int i = 1; i < length; i++) {
                if (this.array[i - 1].compareTo(array[i]) < 0) continue;
                temp = this.array[i];
                t = i - 1;

                while ((t >= 0) && (this.array[t].compareTo(temp) > 0)) {
                    this.array[t + 1] = this.array[t];
                    t--;
                }
                this.array[t + 1] = temp;
            }
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.print("Your array crashed!");
            String[] nullArray = new String[]{};
            return nullArray;
        }
        return this.array;
    }
}
