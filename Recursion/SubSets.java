package Recursion;
import java.util.ArrayList;

public class SubSets {
    static ArrayList<ArrayList<Integer>> returnSets(ArrayList<Integer> in, ArrayList<Integer> output){
        if(in.size()==0){
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            arr.add(output);
            return arr;
        }

        ArrayList<Integer> nextIn = new ArrayList<>(in.size());
        for(int i=1 ; i<in.size() ; i++){
            nextIn.set(i-1,in.get(i));
        }

        ArrayList<Integer> output2 = new ArrayList<>();
        output2.addAll(output);

        ArrayList<ArrayList<Integer>> left = returnSets(in,output);
        ArrayList<ArrayList<Integer>> right = returnSets(in,output2);

        left.addAll(right);
        return left;
    }
}
