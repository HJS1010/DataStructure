package com.stone.stack;

/**
 * 括号匹配
 */
public class Solution_20 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c || '[' == c || '{' == c) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character topChar = stack.pop();
                if (')' == c && '(' != topChar) {
                    return false;
                }
                if (']' == c && '[' != topChar) {
                    return false;
                }
                if ('}' == c && '{' != topChar) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(Solution_20.isValid("([{}])"));
        System.out.println(Solution_20.isValid("()[}"));
        System.out.println(Solution_20.isValid(""));
        System.out.println(Solution_20.isValid("}"));
    }
}
