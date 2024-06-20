package org.example.array;

public class FindTheMissingNumberInArray {
    public static int findMissingNumber(int[] array) {
        int n = array.length + 1;
        int sum = n * (n + 1) / 2;
        for (int i = 0; i < n - 1; i++) {
            sum -= array[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 1, 8, 5, 3, 7};
        System.out.println(findMissingNumber(array));
    }
}
