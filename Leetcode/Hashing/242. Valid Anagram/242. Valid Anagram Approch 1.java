// 37/38 test cases passes


import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();


        for(int i = 0; i < s.length(); i++){
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }

        for(char c : countS.keySet()){
            if(countS.get(c) != countT.getOrDefault(c, 0)){
                return false;
            }
        }

        return true;
        
    }
}
