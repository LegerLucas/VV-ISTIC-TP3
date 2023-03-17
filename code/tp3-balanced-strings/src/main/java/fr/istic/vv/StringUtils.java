package fr.istic.vv;

import java.util.Stack;

public class StringUtils {

    private StringUtils() {}

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char last = stack.pop();
                    if ((c == ')' && last != '(') || (c == '}' && last != '{') || (c == ']' && last != '[')) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

}