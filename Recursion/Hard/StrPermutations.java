package Recursion.Hard;
import java.util.ArrayList;

public class StrPermutations {
	
    public static String[] permutationOfString(String input){
        ArrayList<String> output = getPermutations(input);
        String[] ans = new String[output.size()];
        for(int i=0 ; i<output.size() ; i++){
            ans[i] = output.get(i);
        }
        return ans;
    }

    public static ArrayList<String> getPermutations(String input) {
        if(input.length()==0){
            ArrayList<String> output = new ArrayList<>();
            output.add(input);
            return output;
        }
        ArrayList<String> output = new ArrayList<>();
        for(int i=0 ; i<input.length() ; i++) {
            char ch = input.charAt(i);
            String rem = skipIndex(input,i); // rem is the string without the ith chracter
            ArrayList<String> tempList = getPermutations(rem);
            //This part will return the all combinations of rem string
            //after that we append ith character in all combinations of rem string
            for(int j=0 ; j<tempList.size() ; j++){
                String tempS = ch + tempList.get(j);
                tempList.set(j,tempS);
            }

            output.addAll(tempList);
        }

        return output;
    }

    private static String skipIndex(String input, int i) {
        String rem = "";
        for(int j=0 ; j<input.length() ; j++){
            if(j!=i)
                rem = rem + input.charAt(j);
        }
        return rem;
    }
}
