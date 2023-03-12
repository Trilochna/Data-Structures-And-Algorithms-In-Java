import java.util.*;
import java.io.*;

public class Solution{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<>();

        // Create a stack to store elements that are not processed yet
        Stack<Integer> stack = new Stack<>();

        // Iterate over the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            int current = arr.get(i);

            // If the stack is empty, then there is no smaller element to the right
            if (stack.isEmpty()) {
                result.add(-1);
            }
            // If the top element of the stack is smaller than the current element, then it is the next smaller element
            else if (stack.peek() < current) {
                result.add(stack.peek());
            }
            // If the top element of the stack is greater than or equal to the current element, then pop elements from the stack until a smaller element is found or the stack becomes empty
            else {
                while (!stack.isEmpty() && stack.peek() >= current) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    result.add(-1);
                } else {
                    result.add(stack.peek());
                }
            }

            // Push the current element onto the stack
            stack.push(current);
        }

        // Reverse the result list to get the answer in the correct order
        Collections.reverse(result);
        return result;
    }
}
