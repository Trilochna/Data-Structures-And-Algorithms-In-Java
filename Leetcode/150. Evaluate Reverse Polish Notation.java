class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack();;

        for(String c : tokens){
            if(c.equals("+")){
                stack.add(stack.pop() + stack.pop());
            } else if(c.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b - a);
            } else if(c.equals("*")){
                stack.add(stack.pop() * stack.pop());
            } else if(c.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b / a);
            } else{
                stack.add(Integer.parseInt(c));
            }
        }

        return stack.pop(); 
    }
}
