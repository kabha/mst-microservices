package linkedlists;

import java.util.Stack;

public class LinkedListExample {

    Node head;

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static LinkedListExample insertNode(LinkedListExample list, int newVal) {
        Node newNode = new Node(newVal);
        if (list.head == null) {
            list.head = newNode;
        } else {
            Node lastNode = list.head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
        return list;
    }

    public static LinkedListExample insertNodeInPosition(LinkedListExample list, int n, int value) throws Exception {
        Node newNode = new Node(value);
        if (n == 0) {
            newNode.next = list.head;
            list.head = newNode;
            return list;
        }

        Node curr = list.head;
        for (int i = 0; i < n - 1; i++) {
            if (curr == null) throw new Exception("Position out of bounds");
            curr = curr.next;
        }

        if (curr == null) throw new Exception("Position out of bounds");

        newNode.next = curr.next;
        curr.next = newNode;

        return list;
    }

    public static LinkedListExample deleteNode(LinkedListExample list, int value) {
        if (list.head == null) return list;

        Node curr = list.head, prev = null;

        if (curr != null && curr.value == value) {
            list.head = curr.next;
            return list;
        }

        while (curr != null && curr.value != value) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) return list;

        prev.next = curr.next;

        return list;
    }

    public static LinkedListExample deleteTheNthNode(LinkedListExample list, int n) {
        if (list.head == null) return list;

        Node curr = list.head, prev = null;
        if (n == 0) {
            list.head = curr.next;
            return list;
        }

        for (int i = 0; i < n; i++) {
            if (curr == null) return list;
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) return list;

        prev.next = curr.next;

        return list;
    }

    public static boolean isPalindrome(LinkedListExample list) {
        if (list.head == null) return true;

        Stack<Integer> nodeStack = new Stack<>();
        Node curr = list.head;
        while (curr != null) {
            nodeStack.push(curr.value);
            curr = curr.next;
        }

        curr = list.head;
        while (curr != null) {
            if (nodeStack.pop() != curr.value) {
                return false;
            }
            curr = curr.next;
        }

        return true;
    }

    public static void reverseList(LinkedListExample list) {
        Node prev = null, curr = list.head, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        list.head = prev;
    }

    public static void print(LinkedListExample list) {
        Node currNode = list.head;
        System.out.print("head");
        while (currNode != null) {
            System.out.print("-->" + currNode.value);
            currNode = currNode.next;
        }
        System.out.println();
    }

    public static LinkedListExample mergeTwoSortedLists(LinkedListExample list1, LinkedListExample list2) {
        LinkedListExample mergedList = new LinkedListExample();
        Node p1 = list1.head;
        Node p2 = list2.head;

        while (p1 != null && p2 != null) {
            if (p1.value <= p2.value) {
                insertNode(mergedList, p1.value);
                p1 = p1.next;
            } else {
                insertNode(mergedList, p2.value);
                p2 = p2.next;
            }
        }

        while (p1 != null) {
            insertNode(mergedList, p1.value);
            p1 = p1.next;
        }

        while (p2 != null) {
            insertNode(mergedList, p2.value);
            p2 = p2.next;
        }

        return mergedList;
    }

    public static void main(String[] args) throws Exception {
        LinkedListExample list = new LinkedListExample();
        insertNode(list, 1);
        insertNode(list, 3);
        insertNode(list, 5);
        insertNode(list, 6);
        insertNode(list, 9);

        LinkedListExample list2 = new LinkedListExample();
        insertNode(list2, 2);
        insertNode(list2, 4);
        insertNode(list2, 7);
        insertNode(list2, 10);

        LinkedListExample mergedList = mergeTwoSortedLists(list, list2);
        print(mergedList);

        // Test insertNodeInPosition
        insertNodeInPosition(list, 2, 8);
        print(list);

        // Test deleteTheNthNode
        deleteTheNthNode(list, 2);
        print(list);

        // Test isPalindrome
        LinkedListExample palindromeList = new LinkedListExample();
        insertNode(palindromeList, 1);
        insertNode(palindromeList, 2);
        insertNode(palindromeList, 3);
        insertNode(palindromeList, 2);
        insertNode(palindromeList, 1);
        System.out.println("Is Palindrome: " + isPalindrome(palindromeList));

        // Test reverseList
        reverseList(list);
        print(list);
    }
}
