package linkedlists;

public class MiddleElement {

    // Method to get the length of the linked list
    private static int getLength(Node head) {
        int len = 0;
        Node curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }

    // Method to get the middle node of the linked list
    private static Node getMiddleNode(Node head) {
        int len = getLength(head);
        int index = 0;
        Node curr = head;
        while (index < len / 2) {
            index++;
            curr = curr.next;
        }
        return curr;
    }

    // Method to initialize a linked list from an array
    private static Node initList(int[] list) {
        Node head = null;
        Node prev = null;

        for (int i : list) {
            Node curr = new Node();
            curr.val = i;
            if (head == null) {
                head = curr;
            } else {
                prev.next = curr;
            }
            prev = curr;
        }

        return head;
    }

    // Method to print the linked list
    private static void printList(Node result) {
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static void main(String[] args) {
        Node head = initList(new int[]{1, 2, 3, 4, 5, 6});
        Node result = getMiddleNode(head);
        printList(result);
    }
}

// Node class
class Node {
    int val;
    Node next;
}
