class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int active = 0;
        int j = -1;
        int adj = 0;
        int len = 0;
        List<Integer> segment = new ArrayList<>();

        for(char ch : s.toCharArray()) {
            if(ch == '1') {
                active++;
                if(len > 0) {
                    segment.add(len);
                }
                len = 0;
            } else {
                len++;
            }
        }
        
        if(len > 0) {
            segment.add(len);
        }

        for(int i = 0; i + 1 < segment.size(); i++) {
            adj = Math.max(adj, segment.get(i) + segment.get(i + 1));
        }

        return active + adj;
    }
}