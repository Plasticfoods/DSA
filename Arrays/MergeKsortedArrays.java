package Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKsortedArrays {

    public static ArrayList<Integer> merge2(ArrayList<ArrayList<Integer>> input) {
        int[] index = new int[input.size()];
        for(int i=0 ; i<index.length ; i++){
            index[i] = 0;
        }

        int totalSize = 0;
        for(int i=0 ; i< input.size() ; i++){
            totalSize = totalSize + input.get(i).size();
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int i=0;
        while (i<totalSize) {
            int minE = Integer.MAX_VALUE;
            int position = -1; // its help to remember the min element array so that we can increment that array's index
            for (int j = 0; j < input.size(); j++) {
                if (index[j] < input.get(j).size()) {
                    if (minE > input.get(j).get(index[j])) {
                        minE = input.get(j).get(index[j]);
                        position = j;
                    }
                }
            }
            ans.add(minE);
            index[position]++;
            i++;
        }
        return ans;
    }


}
