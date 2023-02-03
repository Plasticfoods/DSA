package Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(3);
        arr1.add(5);
        arr1.add(8);

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(2);
        arr2.add(4);
        arr2.add(6);

        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(arr2);
        input.add(arr1);

        ArrayList<Integer> input2 = Merge.kSortedArrays(input);
        System.out.println(input2);

        /*int arr[] = {5,4,3,2,1};
        Median.findMedian(arr);*/

    }
}


