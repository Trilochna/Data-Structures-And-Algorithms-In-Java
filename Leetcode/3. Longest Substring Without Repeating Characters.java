class Solution {

    public int lengthOfLongestSubstring(String s) {
            List<Character> substringL = new ArrayList<>();
            int largestlength = 0;
            for(int right = 0; right < s.length(); right++) {
                if(substringL.contains(s.charAt(right))) { 
                    // get the index of the char
                    int index = substringL.indexOf(s.charAt(right));
                    substringL.remove(index);
                    if(index > 0)
                        substringL.subList(0, index).clear();
                }
                substringL.add(s.charAt(right));
                largestlength = Math.max(largestlength, substringL.size());
            }
            return largestlength;
    }
}

// EASY CODE : 

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         Set<Character> set = new HashSet<>();
//         int left = 0;
//         int result = 0;
        
//         for(int right = 0; right < s.length(); right++){
//             while(set.contains(s.charAt(right))){
//                 set.remove(s.charAt(left));
//                 left++;
//             }
//             set.add(s.charAt(right));
//             result = Math.max(result, right - left + 1);
//         }

//         return result;
//     }
// }
