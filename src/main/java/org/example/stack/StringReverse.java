package org.example.stack;

public class StringReverse {

    public static String reverse(String str) {
        Stack stack = new Stack();
        char[] chars = str.toCharArray();

        for (char c : chars) {
            stack.push(c);
        }

        for (int i = 0; i < str.length(); i++) {
            chars[i] = (char) stack.pop();
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String str = "ABCDEFGHI";
        System.out.println(reverse(str));
    }
}
