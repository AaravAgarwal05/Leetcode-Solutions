class Solution {
    public String removeDuplicateLetters(String s) {
        int[] index = new int[26];
        boolean[] isPresent = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            index[s.charAt(i) - 'a'] = i;
        }

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(isPresent[ch - 'a']) {
                continue;
            }

            while(!stack.isEmpty() && stack.peek() > ch && index[stack.peek() - 'a'] > i) {
                isPresent[stack.peek() - 'a'] = false;
                stack.pop();
            }

            stack.push(ch);
            isPresent[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();

        for(char ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }
}