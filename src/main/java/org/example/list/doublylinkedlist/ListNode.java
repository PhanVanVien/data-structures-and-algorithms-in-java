package org.example.list.doublylinkedlist;

public class ListNode {
    private int data;
    private ListNode prev;
    private ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public ListNode getPrev() {
        return prev;
    }

    public ListNode getNext() {
        return next;
    }

    public void setPrev(ListNode prev) {
        this.prev = prev;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
