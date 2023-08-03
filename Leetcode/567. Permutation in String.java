// better Approach: -

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length() || s2.length() == 0) return false;
        if(s1.length() == 0) return true;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for(int i = 0; i < s1.length(); i++){
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        for(int i = s1.length(); i < s2.length(); i++){
            if(Arrays.equals(s1Count, s2Count)) return true;
            s2Count[s2.charAt(i - s1.length()) - 'a']--;
            s2Count[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(s1Count, s2Count)) return true;
        else return false;
    }
}

// another Approach : -

// class Solution {
//     public boolean checkInclusion(String s1, String s2) {

//         int matches = 0;

//         if(s1.length() > s2.length()){
//             return false;
//         }

//         int[] arr = new int[26];

//         for(int i = 0; i < s1.length(); i++){
//             arr[s1.charAt(i) - 'a']++;
//         }

//         int left = 0;
//         int right;

//         for(right = 0; right < s1.length(); right++){
//             arr[s2.charAt(right) - 'a']--;
//         }
//         right--;

//         if(isEmpty(arr)){
//             return true;
//         }

//         while(right < s2.length()){
//             arr[s2.charAt(left) - 'a']++;
//             left++;
//             right++;

//             if(right < s2.length()){
//                 arr[s2.charAt(right) - 'a']--;
//             }
//             if(isEmpty(arr)){
//                 return true;
//             }
//         }
//         return isEmpty(arr);
//     }

//     public boolean isEmpty(int[] arr){
//         for(int i = 0; i < arr.length; i++){
//             if(arr[i] != 0){
//                 return false;
//             }
//         }
//         return true;
//     }
// }
