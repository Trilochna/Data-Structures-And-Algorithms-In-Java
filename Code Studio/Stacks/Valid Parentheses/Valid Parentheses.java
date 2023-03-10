import java.util.*;

public class Solution {
    public static boolean isValidParenthesis(String expression) {
        // Write your code here.

        Stack<Character> s = new Stack<>();

        for(char c : expression.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                s.add(c);
            } else {
                if(s.isEmpty()){
                    return false;
                }
                if(c == ')' && s.peek() != '(' || c == '}' && s.peek() != '{' || c == ']' && s.peek() != '['){
                    return false;
                }
                s.pop();             
            }
        }
        return s.isEmpty();
    }
}
