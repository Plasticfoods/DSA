package garbage;

public class g1 {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;

        try{
            int c = fun(a,b);
            System.out.print("ans = "+c);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    static int fun(int a, int b) throws Exception{
        if(b==0){
            Exception e = new Exception("b cann't be zero");
            throw e;
        }

        return a/b;
    }
}
