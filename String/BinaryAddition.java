package String;

public class BinaryAddition {
	
	public static String addBinary(String a, String b) {
		if(a.equals("0"))
			return b;
		if(b.equals("0"))
			return a;
		
		StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i=a.length()-1, j=b.length()-1;
        while(i>=0 && j>=0) {
        	int sum = carry + (a.charAt(i)-48) + (b.charAt(j)-48);
        	int binary = getBinary(sum);
        	sb.append(binary%10);
        	carry = getDecimal(binary/10);
        	i--;
        	j--;
        }
        while(i>=0) {
        	int sum = carry + (a.charAt(i)-48);
        	int binary = getBinary(sum);
        	sb.append(binary%10);
        	carry = getDecimal(binary/10);
        	i--;
        }
        while(j>=0) {
        	int sum = carry + (b.charAt(j)-48);
        	int binary = getBinary(sum);
        	sb.append(binary%10);
        	carry = getDecimal(binary/10);
        	j--;
        }
        if(carry!=0)
        	sb.append(carry);
        return sb.reverse().toString();
    }
	
	private static int getBinary(int num) {
    	if(num==0 || num==1)
    		return num;
    	StringBuilder sb = new StringBuilder();
    	while(num != 0) {
    		if(num==1) {
    			sb.append("1");
    			break;
    		}
    		sb.append(num%2);
    		num = num/2;
    	}
    	int binary = 0;
    	for(int i=sb.length()-1 ; i>=0 ; i--) {
    		binary = binary*10 + (sb.charAt(i)-48);
    	}
    	return binary;
    }
	
	private static int getDecimal(int binary) {
		if(binary==0 || binary==1)
			return binary;
		int num = 0;
		int power = 0;
		while(binary != 0) {
			num = num + (binary%10)*(int)Math.pow(2,power);
			power++;
			binary = binary/10;
		}
		return num;
	}
	
	public static void main(String[] args) {
		System.out.println(addBinary("1101","1"));
	}
}
