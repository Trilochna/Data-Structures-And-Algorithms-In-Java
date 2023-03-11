import java.util.Stack;

public class Solution {

	static void insertAtBottom(Stack<Integer> s, int element){

		if(s.isEmpty()){
			s.push(element);
			return;
		}

		int num = s.peek();
		s.pop();

		insertAtBottom(s, element);

		s.push(num);
	}


	
    
	public static void reverseStack(Stack<Integer> stack) {
		// write your code here

		if(stack.isEmpty()){
			return;
		}
		
		int num = stack.peek();
		stack.pop();

		reverseStack(stack);

		insertAtBottom(stack, num);
	}

}
