class Solution {
    Map<String, List<String>> map = new HashMap<>();

    public String encode(List<String> strs) {
        String s = "";
        for(String str : strs){
            s += str;
        }
        map.put(s, strs);
        return s;
    }

    public List<String> decode(String str) {
        return map.get(str);
    }
}
