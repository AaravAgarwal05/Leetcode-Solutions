class Solution {
    public String removeDuplicateLetters(String s) {
        int[] index = new int[26];
        boolean[] isPresent = new boolean[26];
        Deque<Character> dq = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            index[s.charAt(i) - 'a'] = i;
        }

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if(isPresent[ch - 'a']) {
                continue;
            }

            while(!dq.isEmpty() && dq.peekLast() > ch && index[dq.peekLast() - 'a'] > i) {
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