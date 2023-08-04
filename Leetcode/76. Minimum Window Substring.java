class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || s.length() < t.length()) return "";
        // Strin t = "ABC" using hashmap
        // key values pair present
        // key - character
        // value - store count (number of times it was prpesent i.e frequency of the letter)
        Map<Character, Integer> map = new HashMap<>();
        // here we will process string t and fill the hashmap 
        for(char c : t.toCharArray()){
        // if the character is already present in the hashmap then we will add the value i.e increment
            if(map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        } // the table has been filled
        // Now start searching in string s
        int count = 0; // if it is equal to the length of t then the required characters are said to be found
        int start = 0; // left pointer of sliding window // manage left boundary of string s
        int minLength = Integer.MAX_VALUE; // for calculating min length of substring to be returned as result
        int minLeft = 0; // min window left pointer starts from this
        // processing string s
        for(int i = 0; i < s.length(); i++){ // will strech right boundary like, start---------i.....
            // check if the characters are present in the table or not
            if(map.containsKey(s.charAt(i))) { 
                // if yes then decrement the count of that character
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            // in the table the count of any character should not go in negative i.e no character should be used extra
            if(map.get(s.charAt(i)) >= 0){
                // if already the eligible character is used then we will increment the count
                // to show it is a eligible character
                count++;
            }
            }

            // when a eligible window having all the required characters will be found
            while(count == t.length()){
                // save length of the current eligible window
                if(minLength > i - start + 1){
                    minLength = i - start + 1; // length saved
                    minLeft = start;
                }
                // and we have to move the left boundary of that window such that the window becomes uneligible again by removing character
                if(map.containsKey(s.charAt(start))){ // check if left side character is eligible or not
                    // eligible character found to be removed
                    // increment in table and decrement in count
                    map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                    if(map.get(s.charAt(start)) > 0){
                        count--;
                    }
                }
                // if not eligible character that remove it directly by incrementing lef tpointer and shrinking window
                start++;
            }
        }
        // if no eligible window found and while loop didn't operate
        if(minLength > s.length()){
            return "";
        }
        // return minimum window using the length we have giving us the infor about from till where the substring resultant is present
        return s.substring(minLeft, minLeft + minLength);
    }
}
