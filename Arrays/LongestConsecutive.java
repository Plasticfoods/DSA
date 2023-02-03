package Arrays;
import java.util.Arrays;

public class LongestConsecutive {
    //longest consecutive sequence in array
    //brute force method
    static int method2(int[] arr){
        if(arr.length==0)
            return 0;

        Arrays.sort(arr);
        int ans=1, currLength=1;
        int prev = arr[0];

        for(int i=1 ; i<arr.length ; i++){
            if(arr[i]==prev+1)
                currLength++;
            else
                currLength=1;
            prev = arr[i];
            ans = Math.max(ans,currLength);
        }

        return ans;
    }
}
