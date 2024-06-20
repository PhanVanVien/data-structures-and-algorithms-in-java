package org.example.array;

public class RemoveEvenInteger {

    public static void printArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int[] removeEven(int[] array) {
        int n = array.length;
        int oddCount = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] % 2 != 0) {
                oddCount++;
            }
        }
        int[] result = new int[oddCount];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] % 2 != 0) {
                result[index] = array[i];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int[] result = removeEven(array);
        printArray(result);
    }
}
