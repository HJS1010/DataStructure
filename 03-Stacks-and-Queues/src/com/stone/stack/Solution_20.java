package com.stone.stack;

import java.util.HashMap;

/**
 * 括号匹配
 */
public class Solution_20 {
    private HashMap<Character, Character> map;

    public Solution_20() {
        map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                Character topChar = stack.isEmpty() ? '#' : stack.pop();
                if (topChar != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution_20().isValid("([{}])"));
        System.out.println(new Solution_20().isValid("()[}"));
        System.out.println(new Solution_20().isValid(""));
        System.out.println(new Solution_20().isValid("}"));
    }
}
