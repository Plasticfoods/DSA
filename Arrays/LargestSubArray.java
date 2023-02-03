package Arrays;
import java.util.HashMap;

public class LargestSubArray {
    static int zeroSum(int arr[]){
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxLen=0, sum=0;
        for(int i=0 ; i<arr.length ; i++){
            sum += arr[i];
            if(arr[i]==0 && maxLen==0)
                maxLen = 1;
            if(sum==0)
                maxLen = i+1;
            if(map.containsKey(sum))
                maxLen = Math.max(maxLen,i-map.get(sum));
            else
                map.put(sum,i);
        }
        return maxLen;
    }

    static int zeroSum2(int arr[]){
        if(arr.length==0)
            return 0;

        int maxLen = 0;
        for(int i=0 ; i<arr.length ; i++){
            int currSum = 0;
            for(int j=i ; j<arr.length ; j++){
                currSum += arr[j];
                if(currSum==0){
                    maxLen = Math.max(maxLen,j-i+1);
                }
            }
        }

        return maxLen;
    }
}
