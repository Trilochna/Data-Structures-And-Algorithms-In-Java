class TimeMap {

    HashMap<String, List<Pair<String, Integer>>> store;

    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!store.containsKey(key)){
            store.put(key, new ArrayList<>());
        }
        store.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!store.containsKey(key)){return "";}
        List<Pair<String, Integer>> list = store.get(key); // store result;
        return binarySearch(list, timestamp);
    }

    public String binarySearch(List<Pair<String, Integer>> list, int timestamp){
                // start binary search

        int left = 0;
        int right = list.size() - 1;

        while(left < right){
            int mid = left + (right - left + 1) / 2;

            if(list.get(mid).getValue() <= timestamp){ // because it is the closet or the valid value of result so far 
                left = mid;
            } else { // if the time value is greater than time stamp that is not allowed because time cannot be in future
                right = mid - 1;
            }
        }
        return list.get(left).getValue() <= timestamp ? list.get(left).getKey() : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
