package linkedlists;

public class DoubleLinkedList {

    private Node head, tail = null;

    private class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void insertNodeAtEnd(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void insertNodeFirst(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
    }

    public void deleteNodeFirst() {
        if (head == null) {
            System.out.println("The linked list is empty!");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteNodeLast() {
        if (tail == null) {
            System.out.println("The linked list is empty!");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }
}
