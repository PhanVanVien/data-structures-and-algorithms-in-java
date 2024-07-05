package org.example.queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {
    public static String[] generateBinaryNumbers(int number) {
        String[] result = new String[number];
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        for (int i = 0; i < number; i++) {
            result[i] = queue.poll();
            String number1 = result[i] + "0";
            String number2 = result[i] + "1";
            queue.offer(number1);
            queue.offer(number2);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] binaryArray = generateBinaryNumbers(5);
        for (String binaryNumber : binaryArray) {
            System.out.print(binaryNumber + " ");
        }
    }
}
