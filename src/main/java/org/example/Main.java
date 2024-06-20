package org.example;

public class Main {

    public void printArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void arrayDemo() {
        int[] myArray = new int[5];
        myArray[0] = 5;
        myArray[1] = 1;
        myArray[2] = 3;
        myArray[3] = 5;
        myArray[4] = 6;
        printArray(myArray);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.arrayDemo();
    }
}