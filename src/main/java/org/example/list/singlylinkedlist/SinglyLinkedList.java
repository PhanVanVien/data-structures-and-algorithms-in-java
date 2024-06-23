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

    public static void display(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.getData() + " --> ");
            listNode = listNode.getNext();
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
        while (current != null && current.getNext() != null) {
            if (current.getData() == current.getNext().getData()) {
                current.setNext(current.getNext().getNext());
            } else {
                current = current.getNext();
            }
        }
    }

    public void insertInSortedList(int value) {
        ListNode newNode = new ListNode(value);
        ListNode currentNode = head;
        ListNode temp = null;
        while (currentNode != null && currentNode.getData() < newNode.getData()) {
            temp = currentNode;
            currentNode = currentNode.getNext();
        }
        newNode.setNext(currentNode);
        temp.setNext(newNode);
    }

    public void deleteNode(int key) {
        ListNode tempNode = null;
        ListNode currentNode = head;
        if (currentNode != null && currentNode.getData() == key) {
            head = head.getNext();
            return;
        }
        while (currentNode != null && currentNode.getData() != key) {
            tempNode = currentNode;
            currentNode = currentNode.getNext();
        }
        if (currentNode == null) {
            return;
        }
        tempNode.setNext(currentNode.getNext());
    }

    public boolean hasCycle() {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.getNext() != null) {
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();

            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }

    public ListNode startNodeInALoop() {
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while (fastPointer != null && fastPointer.getNext() != null) {
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();

            if (slowPointer == fastPointer) {
                return getStartingNode(slowPointer);
            }
        }
        return null;
    }

    public ListNode getStartingNode(ListNode slowPointer) {
        ListNode tempNode = head;
        while (tempNode != slowPointer) {
            tempNode = tempNode.getNext();
            slowPointer = slowPointer.getNext();
        }
        return tempNode;
    }

    public ListNode removeLoop() {
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while (fastPointer != null && fastPointer.getNext() != null) {
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();

            if (slowPointer == fastPointer) {
                removeLoop(slowPointer);
            }
        }
        return null;
    }

    public void removeLoop(ListNode slowPointer) {
        ListNode tempNode = head;
        while (tempNode.getNext() != slowPointer.getNext()) {
            tempNode = tempNode.getNext();
            slowPointer = slowPointer.getNext();
        }
        slowPointer.setNext(null);
    }

    public static ListNode merge(ListNode a, ListNode b) {
        // 1 -> 4 -> 6 -> null
        // 2 -> 5 -> 7 -> null
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;

        while (a != null && b != null) {
            if (a.getData() <= b.getData()) {
                tail.setNext(a);
                a = a.getNext();
            } else {
                tail.setNext(b);
                b = b.getNext();
            }
            tail = tail.getNext();
        }
        if (a == null) {
            tail.setNext(b);
        } else {
            tail.setNext(a);
        }

        return dummyNode.getNext();
    }

    public static ListNode add(ListNode a, ListNode b) {
        ListNode dummyNode = new ListNode(0);
        ListNode tailNode = dummyNode;
        int carry = 0;
        while (a != null || b != null) {
            int x = a != null ? a.getData() : 0;
            int y = b != null ? b.getData() : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            tailNode.setNext(new ListNode(sum % 10));
            tailNode = tailNode.getNext();
            if (a != null) a = a.getNext();
            if (b != null) b = b.getNext();
        }
        if (carry > 0) {
            tailNode.setNext(new ListNode(carry));
        }
        return dummyNode.getNext();
    }

    public static void main(String[] args) {
        SinglyLinkedList s1 = new SinglyLinkedList();
        s1.head = new ListNode(5);

        SinglyLinkedList s2 = new SinglyLinkedList();
        s2.head = new ListNode(5);

        s1.insertLast(4);
        s1.insertLast(3);
        s1.insertLast(2);
        s1.insertLast(1);


        s2.insertLast(4);

        s1.display();
        s2.display();

        display(add(s1.head, s2.head));
        // we have 5 4 3 2 1 for 12345
        // 54 for 45
        // 12345
        // +  45
        // -----
        // 12390
        // You can reverse list to see actual value
    }
}
