package org.example.list.circularsinglylinkedlist;

import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {
    private ListNode last;
    private int length;

    public CircularSinglyLinkedList() {
        this.last = null;
        this.length = 0;
    }

    public int length() {
        return this.length;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public void creteCircularSinglyLinkedList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        first.setNext(first);
//        second.setNext(third);
//        third.setNext(fourth);
//        fourth.setNext(first);

        this.last = first;
    }

    public void display() {
        ListNode currentNode = last.getNext();

        if (isEmpty()) {
            throw new NoSuchElementException("List is already empty");
        }

        while (currentNode != last) {
            System.out.print(currentNode.getData() + " --> ");
            currentNode = currentNode.getNext();
        }
        System.out.println(currentNode.getData());
    }

    public void insertFirst(int data) {
        ListNode newNode = new ListNode(data);
        if (last == null) {
            last = newNode;
        } else {
            newNode.setNext(last.getNext());
        }
        last.setNext(newNode);
        length++;
    }

    public void insertLast(int data) {
        ListNode newNode = new ListNode(data);

        if (last == null) {
            last = newNode;
            newNode.setNext(last);
        } else {
            newNode.setNext(last.getNext());
            last.setNext(newNode);
            last = newNode;
        }
        length++;
    }

    public ListNode deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        ListNode temp = last.getNext();
        if (last.getNext() == last) {
            last = null;
        } else {
            last.setNext(temp.getNext());
        }

        temp.setNext(null);
        length--;
        return temp;
    }

    public ListNode deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is already empty");
        }

        ListNode first = last.getNext();
        ListNode temp = last;
        if (first == last) {
            last = null;
        } else {
            ListNode current = first;
            while (current.getNext() != last) {
                current = current.getNext();
            }
            current.setNext(first);
            last = current;
        }
        length--;
        return temp;
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();

//        list.creteCircularSinglyLinkedList();
//        list.display();
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.deleteLast();
        list.display();
    }
}
