class TimeStampedValues{
    public int timestamp;
    public String value;

    public  TimeStampedValues(int timestamp, String value){
        this.timestamp = timestamp;
        this.value = value;
    }
}


class TimeMap {

    Map<String, List<TimeStampedValues>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
            map.put(key, new ArrayList<>());
        
        map.get(key).add(new TimeStampedValues(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";
        
        List<TimeStampedValues> arr = map.get(key);
        int ind = binarySearch(arr, timestamp);
        if(ind != -1)
            return arr.get(ind).value;
        return "";
    }

    public int binarySearch(List<TimeStampedValues> arr, int timestamp){
        int ind = -1;

        int l = 0;
        int h = arr.size()-1;

        while(l<=h){
            int m = l + (h-l)/2;
            if(arr.get(m).timestamp == timestamp)
                return m;
            else if(arr.get(m).timestamp < timestamp){
                ind = m;
                l = m+1;
            }
            else
                h = m-1;
        }

        return ind;
    }
}
