class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            int[] fq = getFq(str);

            StringBuilder sb = new StringBuilder();
            for(int num : fq){
                sb.append(num + "@");
            }
            String finall = sb.toString();
            if(!map.containsKey(finall))
                map.put(finall, new ArrayList<>());
            map.get(finall).add(str);
        }

        List<List<String>> res = new ArrayList<>();

        for(List<String> r : map.values())
            res.add(new ArrayList<>(r));
        
        return res;
    }
    int[] getFq(String str){
        int[] res = new int[26];

        for(char ch : str.toCharArray())
            res[ch-'a']++;
        return res;
    }
}
