package org.example.list.singlylinkedlist;

public class SinglyLinkedList {
    private ListNode head;

    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.getData() + " --> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public int length() {
        if (head == null) {
            return 0;
        }
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.getNext();
        }
        return length;
    }

    public void insertFirst(int data) {
        ListNode newNode = new ListNode(data);
        newNode.setNext(head);
        this.head = newNode;
    }

    public void insertLast(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = this.head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    public void insertAtPosition(int position, int value) {
        ListNode newNode = new ListNode(value);

        if (position == 1) {
            newNode.setNext(head);
            head = newNode;
        } else {
            int count = 1;
            ListNode previousNode = head;
            while (count < position - 1) {
                previousNode = previousNode.getNext();
                count++;
            }
            newNode.setNext(previousNode.getNext());
            previousNode.setNext(newNode);
        }
    }

    public ListNode deleteFirst() {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        head = head.getNext();
        temp.setNext(null);
        return temp;
    }

    public ListNode deleteLast() {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode current = head;
        ListNode previousNode = null;
        while (current.getNext() != null) {
            previousNode = current;
            current = current.getNext();
        }
        previousNode.setNext(null);
        return current;
    }

    public void deleteAtPosition(int position) {
        if (position == 1) {
            head = head.getNext();
        } else {
            int currentPosition = 1;
            ListNode previous = head;
            while (currentPosition < position - 1) {
                previous = previous.getNext();
                currentPosition++;
            }
            ListNode nodeAtPosition = previous.getNext();
            previous.setNext(nodeAtPosition.getNext());
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(5);

        singlyLinkedList.head.setNext(second);
        second.setNext(third);
        third.setNext(fourth);

        singlyLinkedList.display();
        singlyLinkedList.deleteAtPosition(3);
        singlyLinkedList.display();
    }
}
