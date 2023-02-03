package Recursion;

public class Strings {
    public static String skipString(String input, String k){
        return helper2(input,"",k);
    }

    private static String helper2(String input, String output, String k){
        if(input.length()==0)
            return output;
        if(input.startsWith(k))
            return helper2(input.substring(k.length()), output, k);

        output = output + input.charAt(0);
        return helper2(input.substring(1),output,k);
    }

    public static String skipChar(String input, char k) {
        return helper1(input,"",k);
    }

    private static String helper1(String input, String output, char k) {
        if(input.length()==0)
            return output;
        if(k==input.charAt(0))
            return helper1(input.substring(1),output,k);
        output = output + input.charAt(0);
        return helper1(input.substring(1),output,k);
    }
}
