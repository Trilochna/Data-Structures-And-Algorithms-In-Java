import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    public static boolean findRedundantBrackets(String s) 
    {
        // Write your code here.
        Stack<Character> st = new Stack<>();
      
   for(int i = 0; i< s.length(); i++){
       
       if(s.charAt(i) == '(' || s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/'){
           st.push(s.charAt(i));
       }
       else{
           if(s.charAt(i) == ')'){
               boolean isR = true;
               while(st.peek() != '('){
                   char t = st.peek();
                   if(t == '+' || t == '-' || t == '*' || t == '/'){
                       isR = false;
                   }
                   st.pop();
               }
               st.pop();
               
               if(isR == true)
                   return true;
           }
       }
   }
   return false;
    }
}
