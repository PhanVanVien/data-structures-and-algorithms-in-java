package org.example.list.doublylinkedlist;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int length;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public int length() {
        return this.length;
    }

    public void displayForward() {
        if (head == null) {
            return;
        }
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " --> ");
            currentNode = currentNode.getNext();
        }
        System.out.println("null");
    }

    public void displayBackward() {
        if (tail == null) {
            return;
        }
        ListNode currentNode = tail;
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " --> ");
            currentNode = currentNode.getPrev();
        }
        System.out.println("null");
    }

    public void insertFirst(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.setPrev(newNode);
        }
        newNode.setNext(head);
        head = newNode;
        length++;
    }

    public void insertLast(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        newNode.setPrev(tail);
        tail = newNode;
        length++;
    }

    public ListNode deleteFirst() {
        // null <-- 1 <--> 2 <--> 3 <--> 4 --> null
        ListNode tempNode = head;
        if (head == null) {
            throw new NoSuchElementException();
        }

        if (head == tail) {
            tail = null;
        } else {
            head.getNext().setPrev(null);
        }

        head = head.getNext();
        tempNode.setNext(null);
        length--;

        return tempNode;
    }

    public ListNode deleteLast() {
        // null <-- 1 <--> 2 <--> 3 <--> 4 -->
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        ListNode tempNode = tail;
        if (head == tail) {
            head = null;
        } else {
            tail.getPrev().setNext(null);
        }

        tail = tail.getPrev();
        tempNode.setPrev(null);
        length--;

        return tempNode;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        System.out.println(list.isEmpty());

        list.insertFirst(1);
//        list.insertLast(10);
//        list.insertLast(15);
//        list.insertLast(25);

//        list.displayBackward();
        list.displayForward();

        System.out.println(list.deleteLast().getData());
        list.displayForward();
        System.out.println(list.tail);

    }
}
