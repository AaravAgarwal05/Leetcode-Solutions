class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        char prev = '@';
        int active = 0;
        int j = -1;
        int adj = 0;
        List<Integer> segment = new ArrayList<>();

        for(char ch : s.toCharArray()) {
            if(ch == '1') {
                active++;
            }

            if(prev != ch && ch == '0') {
                j++;
                segment.add(0);
            }

            if(ch == '0') {
                segment.set(j, segment.get(j) + 1);
            }

            prev = ch;
        }

        for(int i = 0; i + 1 < segment.size(); i++) {
            adj = Math.max(adj, segment.get(i) + segment.get(i + 1));
        }

        return active + adj;
    }
}