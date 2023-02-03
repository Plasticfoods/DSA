package Stack;
import java.util.Stack;

class MinStack {
	private Stack<Pair> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
        	stack.push(new Pair(val, val));
        }
        else {
        	int min = Math.min(val, stack.peek().min);
        	stack.push(new Pair(val, min));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().element;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
    
    private class Pair {
    	int element;
    	int min;
    	
    	Pair(int element, int min) {
    		this.element = element;
    		this.min = min;
    	}
    } 
}
