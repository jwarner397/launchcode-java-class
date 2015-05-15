/**
 * Created by Joseph on 5/13/2015.
 */
public class MergeSort implements SortStrategy {

    private String[] array;

    public MergeSort(String[] array) {
        this.array = array;
    }

    // sorts with Merge Sort method and returns sorted array

    @Override
    public String[] sortArray() {

        int length = this.array.length;

        return sort(this.array);

    }

    public String[] sort(String[] array){
    // sort: reorders the elements of elts so that they are in
    // increasing order.
        int length = array.length;
        if(array.length > 1) {
            // split the array into two pieces, as close to the same
            // size as possible.
            String [] first = extract(array, 0, length / 2);
            String [] last = extract(array, (length / 2), length);

            // sort each of the two halves recursively
            sort(first);
            sort(last);

            // merge the two sorted halves together
            merge(array, first, last);
        }
        return array;
    }
    // extract: returns a subarray of strings
    public String[] extract(String[] elts, int start, int last) {
        String[] ret = new String[last - start];
        for(int i = 0; i < ret.length; i++) ret[i] = elts[start + i];
        return ret;
    }

    // merges arrays a and b, placing the result into the
    // array dest.
    public void merge(String[] dest, String[] a, String[] b) {
        int i = 0;
        int j = 0;
        try {
            while (i < a.length && j < b.length) {
                if (a[i].compareTo(b[j]) < 0) {
                    dest[i + j] = a[i];
                    ++i;
                } else {
                    dest[i + j] = b[j];
                    ++j;
                }
            }
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.print("Your array crashed!");
        }
        for(; i < a.length; i++) dest[i + j] = a[i];
        for(; j < b.length; j++) dest[i + j] = b[j];
    }

}

