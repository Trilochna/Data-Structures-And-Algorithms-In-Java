class Solution {

    Stack<Character> stack = new Stack();
    List<String> result = new ArrayList();

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return result;
    }

    // 3 steps to follow:
        // only add one open paranthesis if open < n
        // only add one close paranthesis if close < open 
        // valid if open  == clode == n

    private void backtrack(int openN, int closeN, int n){

//stack = ["(", "(", ")", ")", "{", "{", "}"]


// Iteration 1: temp = "" + "(" = "("
// Iteration 2: temp = "(" + "(" = "(("
// Iteration 3: temp = "((" + ")" = "(())"
// Iteration 4: temp = "(())" + ")" = "(()))"
// Iteration 5: temp = "(()))" + "{" = "(())){"
// Iteration 6: temp = "(())){" + "{" = "(())){{"
// Iteration 7: temp = "(())){{" + "}" = "(())){{}}"

// res = ["(())){{}}"]


            if(openN == closeN && closeN == n){
                Iterator iterate = stack.iterator();
                String temp = "";
                while(iterate.hasNext()){
                    temp = temp + iterate.next();
                }
                result.add(temp);
            }

            if(openN < n){
                stack.push('(');
// recursion is used to perform these functions till the conditions aren't satisfied'
                backtrack(openN + 1, closeN, n);
                stack.pop();
            }

            if(closeN < openN){
                stack.push(')');
                backtrack(openN, closeN + 1, n);
                stack.pop();
            }
    }
}
