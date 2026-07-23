class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        
        for(String str : strs) {
            char[] strA = str.toCharArray();
            Arrays.sort(strA);
            String sstr = new String(strA);
            
            if(!map.containsKey(sstr)) {
                map.put(sstr, new ArrayList<>());
            }
            
            map.get(sstr).add(str);
        }

        for(String str : map.keySet()) {
            result.add(map.get(str));
        }

        return result;
    }
}