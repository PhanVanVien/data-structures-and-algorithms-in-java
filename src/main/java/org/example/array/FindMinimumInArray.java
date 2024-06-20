package org.example.array;

public class FindMinimumInArray {
    public static int findMinimum(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 9};
        System.out.println(findMinimum(array));
    }
}
