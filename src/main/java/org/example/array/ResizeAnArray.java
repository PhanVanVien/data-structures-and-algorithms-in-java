package org.example.array;

public class ResizeAnArray {
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int[] resizeArray(int[] array, int newSize) {
        int[] tempArray = new int[newSize];
        for (int i = 0; i < array.length; i++) {
            tempArray[i] = array[i];
        }
        return tempArray;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        printArray(array);
        array = resizeArray(array, 10);
        System.out.println(array.length);
    }
}
