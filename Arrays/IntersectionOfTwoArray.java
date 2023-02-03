package Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfTwoArray {
    static ArrayList<Integer> intersection(int arr1[], int arr2[]){
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0 ; i<arr1.length ; i++){
            int e = arr1[i];
            if(map.containsKey(e)){
                int v = map.get(e);
                v++;
                map.put(e,v);
            }
            else
                map.put(e,1);
        }

        for(int i=0 ; i<arr2.length ; i++){
            int e = arr2[i];
            if(map.containsKey(e)){
                if(map.get(e)>0){
                    ans.add(e);
                    int v = map.get(e);
                    v--;
                    map.put(e,v);
                }
            }
        }

        return ans;
    }
}
