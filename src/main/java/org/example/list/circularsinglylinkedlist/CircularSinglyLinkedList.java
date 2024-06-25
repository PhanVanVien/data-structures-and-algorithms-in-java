package org.example.list.circularsinglylinkedlist;

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

    public static void main(String[] args) {
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();

        list.creteCircularSinglyLinkedList();
        list.display();
        list.insertLast(100);
        list.insertLast(101);
        list.insertLast(100);
        list.display();
    }
}
