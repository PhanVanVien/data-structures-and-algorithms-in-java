package org.example;

import java.util.Stack;

public class Main {
//    public void printArray(int[] array) {
//        int n = array.length;
//        for (int i = 0; i < n; i++) {
//            System.out.print(array[i] + " ");
//        }
//        System.out.println();
//    }

    //    public void arrayDemo() {
//        int[] myArray = new int[5];
//        myArray[0] = 5;
//        myArray[1] = 1;
//        myArray[2] = 3;
//        myArray[3] = 5;
//        myArray[4] = 6;
//        printArray(myArray);
//    }
//    public static int lengthOfLastWord(String s) {
//        int count = 0;
//        s.trim();
//
//        for (int i = s.length() - 1; i >= 0; i--) {
//            if (s.charAt(i) != ' ') {
//                count++;
//            } else if (count > 0) {
//                return count;
//            }
//        }
//        return count;
//    }

    //    public static boolean isPalindrome(int x) {
//        String stringX = String.valueOf(x);
//        int start = 0;
//        int end = stringX.length() - 1;
//        while (start < end) {
//            if (stringX.charAt(start) != stringX.charAt(end)) {
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
//    }
    public static int convertRomanToNumber(char roman) {
        int value = 0;
        switch (roman) {
            case 'I':
                value = 1;
                break;
            case 'V':
                value = 5;
                break;
            case 'X':
                value = 10;
                break;
            case 'L':
                value = 50;
                break;
            case 'C':
                value = 100;
                break;
            case 'D':
                value = 500;
                break;
            case 'M':
                value = 1000;
                break;
        }
        return value;
    }

    public static int romanToInt(String s) {
        int answer = 0, prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (convertRomanToNumber(s.charAt(i)) < prev) {
                answer -= convertRomanToNumber(s.charAt(i));
            } else {
                answer += convertRomanToNumber(s.charAt(i));
            }
            prev = convertRomanToNumber(s.charAt(i));
        }
        return answer;
    }

    public static void main(String[] args) {
//        Main main = new Main();
//        main.arrayDemo();
//        System.out.println(lengthOfLastWord("Hello World"));
//        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
//        System.out.println(lengthOfLastWord("luffy is still joyboy"));
//        System.out.println(isPalindrome(-12));
        System.out.println(romanToInt("III")
        );
    }
}