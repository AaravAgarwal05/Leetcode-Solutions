class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        Map<String, Boolean> map = new HashMap<>();

        for(String w : wordDict) {
            set.add(w);
        }

        return dfs(s, set, map);
    }

    public boolean dfs(String s, Set<String> set, Map<String, Boolean> map) {
        if(s.equals("")) {
            return true;
        }

        if(map.containsKey(s)) {
            return map.get(s);
        }

        for(int i = 0; i < s.length(); i++) {
            if(set.contains(s.substring(0, i + 1)) && dfs(s.substring(i + 1), set, map)) {
                map.put(s, true);
                return true;
            }
        }

        map.put(s, false);
        return false;
    }
}