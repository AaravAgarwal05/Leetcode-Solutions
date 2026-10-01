import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
           if(s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(' || s.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '{' || s.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        
        return stack.isEmpty();
    }
}