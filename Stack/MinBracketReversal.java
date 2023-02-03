package Stack;
import java.util.Stack;

public class MinBracketReversal {
    public static void main(String[] args) {
        String input = "{}}{";

        System.out.println(countBracketReversals(input));
    }

    public static int countBracketReversals(String input) {
        //Your code goes here
        if(input.length()==0 || input.length()%2!=0)
            return -1;

        int ans=0;
        Stack<Character> st = new Stack<>();
        for(int i=0 ; i<input.length() ; i++)
        {
            if(input.charAt(i)=='{')
                st.push(input.charAt(i));

            if(input.charAt(i)=='}')
            {
                if(st.size()==0 || st.peek()=='}')
                    st.push(input.charAt(i));

                if(st.peek()=='{')
                    st.pop();
            }
        }


        char c1,c2;
        while(st.size()>0)
        {
            c2 = st.pop();
            c1 = st.pop();

            if(c1=='}' && c2=='}')
                ans++;

            else if(c1=='{' && c2=='{')
                ans++;

            else if(c1=='}' && c2=='{')
                ans=ans+2;
        }





        return ans;
    }
}
