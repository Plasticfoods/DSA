package General;

public class HappyNumber {
	
	public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        
        do {
        	slow = squareSum(slow);
        	fast = squareSum(fast);
        	fast = squareSum(fast);
        } while(fast != slow);
        
        if(slow == 1)
        	return true;
        else
        	return false;
    }
    
    private static int squareSum(int n) {
    	if(n == 0)
    		return 0;
        int sum = 0;
        while(n != 0){
        	int rem = n%10;
            sum = sum + (rem*rem);
            n = n/10;
        }
        return sum;
    }
    
    public static void main(String[] args) {
    	System.out.println(isHappy(7));
    }
}	
