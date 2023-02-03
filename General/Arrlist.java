package General;
import java.util.ArrayList;
import java.util.List;

public class Arrlist {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();

        int val=1;
        for(int i=0 ; i<3 ; i++){
            arr.add(new ArrayList<>());
            for(int j=0 ; j<4 ; j++){
                arr.get(i).add(val+j);
            }
            val += 4;
        }

        for(int i=0 ; i<arr.size() ; i++)
            System.out.println(arr.get(i));


    }
}
