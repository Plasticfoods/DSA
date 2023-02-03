package General;

public class Camelize {
	
	public static String camelize(String str) {
		String[] words = str.split("_");
		
		for(int i=1 ; i<words.length ; i++) {
			words[i] = makeCapital(words[i]);
		} 
		
		String res = joinWords(words);
		return res;
	}
	

	private static String makeCapital(String word) {
		char firstLetter = Character.toUpperCase(word.charAt(0));
		String camelCaseWord = "";
		camelCaseWord += Character.toUpperCase(firstLetter);
		
		for(int i=1 ; i<word.length() ; i++) {
			camelCaseWord += word.charAt(i);
		}
		return camelCaseWord;
	}

	private static String joinWords(String[] words) {
		String res = "";
		for(int i=0 ; i<words.length ; i++) {
			res += words[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		String str = "get_element_by_class_name";
		System.out.println(camelize(str));
	}
}
