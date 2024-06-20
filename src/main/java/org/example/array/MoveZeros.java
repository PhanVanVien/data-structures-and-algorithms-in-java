package org.example.array;

public class MoveZeros {
    public static void printArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void moveZeros(int[] array) {
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0 && array[j] == 0) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            if (array[j] != 0) {
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 3, 0, 5, 6, 0, 0, 6};
        printArray(array);
        moveZeros(array);
        printArray(array);
    }
}
