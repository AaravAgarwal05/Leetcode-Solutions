class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == ')' && i < s.length() - 1 && s.charAt(i + 1) == ')') {
                if(stack.isEmpty()) {
                    count++;
                } else {
                    stack.pop();
                }

                i++;
            } else if(ch == ')') {
                if(stack.isEmpty()) {
                    count++;
                } else {
                    stack.pop();
                }

                count++;
            } else {
                stack.push(ch);
            }
        }
        
        while(!stack.isEmpty()) {
            stack.pop();
            count += 2;
        }

        return count;
    }
}