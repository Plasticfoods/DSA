package Arrays;
import java.util.ArrayList;
import java.util.Arrays;

public class UnionTwoArrays {
    static ArrayList<Integer> union2(int a1[], int a2[]){
        Arrays.sort(a1);
        Arrays.sort(a2);

        ArrayList<Integer> ans = new ArrayList<>();
        int i=0, j=0, k=0;
        while(i<a1.length || j<a2.length){
            int e=0;
            if(i>=a1.length)
                e=a2[j++];
            else if(j>=a2.length)
                e=a1[i++];
            else if(a1[i]<a2[j])
                e=a1[i++];
            else
                e=a2[j++];

            if(k==0){
                ans.add(e);
                k++;
            }
            else if(k>0 && e!=ans.get(k-1)){
                ans.add(e);
                k++;
            }
        }

        return ans;
    }
}
