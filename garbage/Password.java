package garbage;

public class Password {
	
	public static String createPassword(String name, int roll) {
		if(name.length()==0 || roll<=0) return null;
		
		String[] words = name.split(" ");
		String fname="", mname="", lname="";
		fname = words[0];
		if(words.length == 3) {
			mname = words[1];
			lname = words[2];
		}
		else {
			lname = words[1];
		}
		
		String password = "";
		password += getString(fname);
		password += getString(mname);
		password += getString(lname);
		password += roll;
		
		return password;
	}
	
	private static String getString(String s) {
		if(s.length() <= 3) {
			return s;
		}
		
		return s.substring(0, 4);
	}

	public static void main(String[] args) {
		String name = "Rajdeep Karmakar";
		int roll = 105;
		System.out.println(createPassword(name, roll));
	}
}
