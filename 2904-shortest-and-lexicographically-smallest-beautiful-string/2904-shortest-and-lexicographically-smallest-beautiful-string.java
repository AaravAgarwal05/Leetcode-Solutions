class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int one = 0;
        int i = 0;
        int j = 0;
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if(a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });

        while(j < s.length()) {
            if(s.charAt(j) == '1') {
                one++;
            }

            while(one > k) {
                if(s.charAt(i) == '1') {
                    one--;
                }
                i++;
            }

            if(one == k) {
                while(s.charAt(i) == '0') {
                    i++;
                }
                pq.add(s.substring(i, j + 1));
            }

            j++;
        }

        return pq.isEmpty() ? "" : pq.poll();
    }
}