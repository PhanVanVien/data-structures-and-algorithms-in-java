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

    public boolean findSearchKey(int searchKey) {
        if (head == null) {
            return false;
        }

        ListNode current = head;
        while (current != null) {
            if (current.getData() == searchKey) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void reverse() {
        // 1 --> 2 --> 3 --> 4 --> null
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            head = previous;
            current = next;
        }
    }

    public ListNode getNthNodeFromEnd(int n) {
        if (head == null) {
            return null;
        }
        int count = 0;
        ListNode mainPtr = head;
        ListNode refPtr = head;
        while (count < n) {
            refPtr = refPtr.getNext();
            count++;
        }
        while (refPtr != null) {
            mainPtr = mainPtr.getNext();
            refPtr = refPtr.getNext();
        }
        return mainPtr;
    }

    public void sortList() {
        ListNode current = head;
        // 1 -> 1 -> 2 -> 3 -> 3
        //
        while (current != null && current.getNext() != null) {
            if (current.getData() == current.getNext().getData()) {
                current.setNext(current.getNext().getNext());
            } else {
                current = current.getNext();
            }
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.head = new ListNode(1);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(2);
        ListNode fourth = new ListNode(3);
        ListNode fifth = new ListNode(3);

        singlyLinkedList.head.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(fifth);

        singlyLinkedList.display();
        singlyLinkedList.sortList();
        singlyLinkedList.display();
    }
}
