package Recursion;

public class ReplacePi {
	static String replacePi(String str, int i) {
		if(i == str.length())
			return "";
		if(str.charAt(i) == 'p') {
			if(i+1<str.length() && str.charAt(i+1)=='i')
				return "3.14"+replacePi(str,i+2);
		}
		return str.charAt(i) + replacePi(str,i+1);		
	}

	public static void main(String[] args) {
		System.out.println(replacePi("apic",0));
	}

}
