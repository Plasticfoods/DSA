package Arrays;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Merge {
    public static ArrayList<Integer> kSortedArrays(ArrayList<ArrayList<Integer>> input) {
        ArrayList<Integer> arr3 = null;
        for(int i=0 ; i<input.size()-1 ; i++){
            if(i==0)
                arr3 = merge(input.get(0),input.get(1));
            else
                arr3 = merge(arr3,input.get(i+1));
        }

        return arr3;
    }

    private static ArrayList<Integer> merge(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        ArrayList<Integer> arr3 = new ArrayList<>(arr1.size()+ arr2.size());
        int i=0, j=0, k=0;
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i)<arr2.get(j)) {
                arr3.add(arr1.get(i));
                k++;
                i++;
            }
            else {
                arr3.add(arr2.get(j));
                k++;
                j++;
            }
        }

        while(i<arr1.size()){
            arr3.add(arr1.get(i++));
            k++;
            i++;
        }

        while(j<arr2.size()){
            arr3.add(arr2.get(j));
            k++;
            j++;
        }
        return arr3;
    }
}
