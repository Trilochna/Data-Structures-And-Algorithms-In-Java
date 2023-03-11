import java.util.* ;
import java.io.*; 
public class Solution 
{
  static void solve(Stack <Integer> s, int x) 
  {
    // Write your code here

    if(s.isEmpty()){
      s.push(x);
      return;
    }

    int num = s.peek();
    s.pop();

    solve(s, x);

    s.push(num);
  }


  public static Stack<Integer> pushAtBottom(Stack <Integer> myStack, int x) 
  {
    // Write your code here
    solve(myStack, x);
    return myStack;
  }
}
