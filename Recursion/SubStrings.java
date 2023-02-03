package Recursion;
import java.util.ArrayList;

public class SubStrings {
    static void print(String input, String output){
        if(input.length()==0){
            System.out.println(output);
            return;
        }

        print(input.substring(1),output+input.charAt(0));
        print(input.substring(1),output);
    }

    static ArrayList<String> returnStrings(String in, String out) {
        if(in.length()==0){
            ArrayList<String> ans = new ArrayList<>(1);
            ans.add(out);
            return ans;
        }

        ArrayList<String> left = returnStrings(in.substring(1),out);
        ArrayList<String> right = returnStrings(in.substring(1),out+in.charAt(0));

        left.addAll(right);
        return left;
    }
}
