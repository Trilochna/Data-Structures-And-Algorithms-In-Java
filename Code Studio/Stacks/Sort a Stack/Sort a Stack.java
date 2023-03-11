import java.util.* ;
import java.io.*; 
public class Solution {

	static void sortInsert(Stack<Integer> stack, int element){

		if(stack.isEmpty() || (!stack.isEmpty() && stack.peek() < element)){
			stack.push(element);
			return;
		}

		int num = stack.peek();
		stack.pop();

		sortInsert(stack, element);

		stack.push(num);
	}

	public static void sortStack(Stack<Integer> stack) {
		// Write your code here.

		if(stack.isEmpty()){
			return;
		}

		int num = stack.peek();
		stack.pop();

		sortStack(stack);

		sortInsert(stack, num);
	}

}
