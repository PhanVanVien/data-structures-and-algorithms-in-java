package org.example.queue;

import java.util.NoSuchElementException;

public class Queue {
    ListNode front;
    ListNode rear;
    int length;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public int length() {
        return this.length;
    }

    public void display() {
        if (isEmpty()) {
            return;
        }

        ListNode currentNode = front;

        while (currentNode != null) {
            System.out.print(currentNode.getData() + " --> ");
            currentNode = currentNode.getNext();
        }
        System.out.println("null");
    }

    public void enqueue(int data) {
        ListNode newNode = new ListNode(data);

        if (isEmpty()) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }
        rear = newNode;
        length++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int frontData = front.getData();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        length--;
        return frontData;
    }

    public int first() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.getData();
    }

    public int last() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return rear.getData();
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        queue.display();

        queue.dequeue();
        queue.dequeue();

        queue.display();
    }
}
