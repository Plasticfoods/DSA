package String;
import java.util.HashMap;

public class LongestSubstringWithoutRepetation {

	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
        if(n == 0)
        	return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        //l to r is a renge without character repeatation
        int l=0, r=0;
        int len = 0;
        while(r < n) {
        	char ch = s.charAt(r);
        	//if map doesnt contain the ch, put the ch
        	if(!map.containsKey(ch))
        		map.put(ch, r);
        	else {
        		int prevChIndex = map.get(ch);
        		//if the previous index of this ch is in the range of l to r,
        		//then l should be starting from the next index where ch was last found
        		if(l<=prevChIndex) 
        			l = prevChIndex+1;
        		//also update the index of ch
        		map.put(ch, r);
        	}
        	len = Math.max(len, r-l+1);
        	r++;
        }
        return len;
    }
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}

}
