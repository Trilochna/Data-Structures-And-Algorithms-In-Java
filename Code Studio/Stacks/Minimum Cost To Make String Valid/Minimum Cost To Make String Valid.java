import java.util.* ;
import java.io.*; 
public class Solution {
    public static int findMinimumCost(String str) {
		// Write your code here

    if(str.length() % 2 == 1){
      return -1;
    }

    Stack<Character> s = new Stack<>();

    for(int i = 0; i < str.length(); i++){
      char ch = str.charAt(i);

      if(ch == '{'){
        s.push(ch);
      } else {
        if(!s.isEmpty() && s.peek() == '{'){
          s.pop();
        } else {
          s.push(ch);
        }
      }
    }

    int a = 0, b = 0;

    while(!s.isEmpty()){
      if(s.peek() == '{'){
        b++;
      } else {
        a++;
      }
      s.pop();
    }

    int ans = (a+1)/2 + (b+1)/2;
    return ans;
    }
}
