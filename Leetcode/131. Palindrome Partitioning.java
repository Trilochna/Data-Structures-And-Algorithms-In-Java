class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> Partsubstring = new ArrayList<>();
        dfsBacktrackHelper(s, result, Partsubstring, 0);
        return result;
    }

    public void dfsBacktrackHelper(String s, List<List<String>> result, List<String> Partsubstring, int index){
        if(index >= s.length()){
            result.add(new ArrayList<>(Partsubstring)); 
            return;
        }

        // if we are not at the end of the string
        // we caan iterate through every single character in our string

        for(int j = index; j < s.length(); j++){
            if(isPalindrome(s, index, j)){
                Partsubstring.add(s.substring(index, j + 1));
                dfsBacktrackHelper(s, result, Partsubstring, j + 1);
                Partsubstring.remove(Partsubstring.size() - 1);
            }
        }

    }

    public boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
