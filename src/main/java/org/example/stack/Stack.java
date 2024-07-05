package org.example.stack;

import java.util.NoSuchElementException;

public class Stack {
    private ListNode top;
    private int length;

    public Stack() {
        this.top = null;
        this.length = 0;
    }

    public int length() {
        return this.length;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public void push(int data) {
        ListNode newNode = new ListNode(data);

        newNode.setNext(top);
        top = newNode;
        length++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        int topData = top.getData();
        top = top.getNext();
        length--;
        return topData;
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return top.getData();
    }

    public void display() {
        ListNode current = top;

        while (current != null) {
            System.out.print(current.getData() + " --> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.display();
    }
}
