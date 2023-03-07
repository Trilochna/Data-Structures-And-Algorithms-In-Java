import java.util.* ;
import java.io.*; 
public class Solution {

    static void solve(Stack<Integer> inputStack, int count, int N) {
		// WRITE YOUR CODE HERE

		if(count == (N/2)-1 && N%2 == 0){
		 inputStack.pop();
		 return;
		}

		if(count == (N/2)){
		 inputStack.pop();
		 return;
		}

		int num = inputStack.peek();
		inputStack.pop();

		solve(inputStack, ++count, N);

		inputStack.push(num);
	}

	public static void deleteMiddle(Stack<Integer> inputStack, int N) {
		// WRITE YOUR CODE HERE

		int count = 0;
     solve(inputStack, count, N);

	}
}
