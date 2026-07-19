class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26];
        boolean[] isPresent = new boolean[26];
        Deque<Character> dq = new ArrayDeque<>();

        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for(char ch : s.toCharArray()) {
            freq[ch - 'a']--;

            if(isPresent[ch - 'a']) {
                continue;
            }

            while(!dq.isEmpty() && dq.peekLast() > ch && freq[dq.peekLast() - 'a'] > 0) {
                isPresent[dq.peekLast() - 'a'] = false;
                dq.pollLast();
            }

            dq.offerLast(ch);
            isPresent[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();

        while(!dq.isEmpty()) {
            sb.append(dq.pollFirst());
        }

        return sb.toString();
    }
}