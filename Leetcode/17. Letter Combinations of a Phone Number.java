class Solution {
    
    Map<Character, String> digitToChar = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"); 

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>(); // if digits is empty we have to return empty array not empty string
        }

        List<String> result = new ArrayList<>();
        String currString = "";
        dfsBacktrack(digits, result, 0, currString);
        return result;
    }

    public void dfsBacktrack(String digits, List<String> result, int index, String currString){
        if(currString.length() == digits.length()){
            result.add(currString);
            return;
        } else if(index >= digits.length()){
            return;
        }else{
        // we want to take the character we are at and map it to the hashmap to get the list of characters corresponding to it
        // and after getting them we would want to go throuogh each character in that string to create the decision tree for backtracking
        // and return the combinations

            String charAtDigit = digitToChar.get(digits.charAt(index));
            //             String letters = phone_map[next_digits.charAt(0) - '2'];
// THIS CAN BE SOLVED WITHOUT 2 PAIR HASHMAP ///////// WILL LEAD TO MORE OPTIMAL SOLUTION
            for(char c : charAtDigit.toCharArray()){
                // toCharArray() method converts the given string into a sequence of characters
                dfsBacktrack(digits, result, index + 1, currString + c); // to add the character we are currently visiting and increment index for the next position to be filled until the combination size is filled fully
            }
        }
    }
}
