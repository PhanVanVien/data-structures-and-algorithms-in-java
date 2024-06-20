package org.example.array;

public class FindSecondMaximumInArray {

    public static void printArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int findSecondMaximumInArray(int[] array) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                secondMax = max;
                max = array[i];
            } else if (array[i] > secondMax && array[i] != max) {
                secondMax = array[i];
            }
        }
        return secondMax;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 6, 4, 5, 6};
        printArray(array);
        System.out.println(findSecondMaximumInArray(array));
    }
}
