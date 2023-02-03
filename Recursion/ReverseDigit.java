package Recursion;

public class ReverseDigit {
    static int reverseDigit(int num, int ans){
        if(num==0)
            return ans;

        ans = (ans*10) + num%10;
        return reverseDigit(num/10, ans);
    }
}
