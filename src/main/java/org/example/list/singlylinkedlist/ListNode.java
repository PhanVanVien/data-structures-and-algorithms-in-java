package org.example.list.singlylinkedlist;

public class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return this.data;
    }

    public void setNext(ListNode listNode) {
        this.next = listNode;
    }

    public ListNode getNext() {
        return this.next;
    }
}
