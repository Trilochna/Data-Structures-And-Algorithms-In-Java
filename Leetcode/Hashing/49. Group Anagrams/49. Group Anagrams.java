class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> result = new HashMap<>();

        for(String s : strs){
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String sortedString = String.valueOf(charArr);
            if(!result.containsKey(sortedString)){
                result.put(sortedString, new ArrayList<>());
            }

            result.get(sortedString).add(s);
        }
        
        return new ArrayList<>(result.values());
    }
}
