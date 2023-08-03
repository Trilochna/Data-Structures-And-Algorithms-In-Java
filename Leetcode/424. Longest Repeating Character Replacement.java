class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];

        int result = 0;
        int left = 0;
        int maxFreq = 0;

        for(int right = 0; right < s.length(); right++){
            count[s.charAt(right) - 'A'] = 1 + count[s.charAt(right) - 'A'];
            // s.charAt(right) - 'A' - this has been done so that index out of bound in array doesn't come and the character are limited within 26 idk'
            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);

            while((right - left + 1) - maxFreq > k){
                count[s.charAt(left) - 'A'] -= 1;
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;

    }
}
