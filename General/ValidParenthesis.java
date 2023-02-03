package General;
import java.util.Stack;

public class ValidParenthesis {
	
	public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0 ; i<s.length() ; i++){
            char bracket = s.charAt(i);
            if(bracket=='(' || bracket=='{' || bracket=='[')
                stack.push(bracket);
            else{
                if(stack.isEmpty())
                    return false;
                if(bracket==')' && stack.peek()=='(')
                    stack.pop();
                else if(bracket=='}' && stack.peek()=='{')
                    stack.pop();
                else if(bracket==']' && stack.peek()=='[')
                    stack.pop();
                else
                    return false;
            }
        }
        
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
	
	public static void main(String[] args) {
    	System.out.println(isValid("()"));
    }
}
