package org.example.stack;

public class StackByArray {
    private int top;
    private int[] array;

    public StackByArray() {
        this(10);
    }

    public StackByArray(int capacity) {
        top = -1;
        array = new int[capacity];
    }

    public void push(int data) {
        if (isFull()) {
            throw new RuntimeException("Stack is full");
        }
        top++;
        array[top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        int result = array[top];
        top--;
        return result;
    }

    public boolean isFull() {
        return this.array.length == size();
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return array[top];
    }

    public void display() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " --> ");
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        StackByArray stack = new StackByArray(3);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.display();

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.top);
    }
}
