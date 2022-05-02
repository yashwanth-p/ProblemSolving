package DSA.Misc;

import java.util.ArrayList;
import java.util.List;

public class LinkedListProblems {

    private static final LinkedList linkedList = new LinkedList();

    public static void main(String[] args) {
        List<Integer> elements = initializeAndGetList();
        linkedList.addMultipleNodesToList(elements);
        linkedList.printList();
        Node reversedHead = linkedList.reverseLinkedList();
        linkedList.printList(reversedHead);
    }

    private static List<Integer> initializeAndGetList() {
        List<Integer> elements = new ArrayList<>();
        elements.add(3);
        elements.add(5);
        elements.add(9);
        elements.add(7);
        elements.add(20);
        elements.add(15);
        return elements;
    }
}

class LinkedList {
    Node head;

    void addNodeToList(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    void printList(Node head) {
        System.out.println();
        if (isEmptyList()) return;
        while (head != null) {
            String pointer = head.next!=null ? " -> ": " ";
            System.out.print(head.data + pointer);
            head = head.next;
        }
    }
    void printList() {
        System.out.println();
        Node cur = head;
        if (isEmptyList()) return;
        while (cur != null) {
            String pointer = cur.next!=null ? " -> ": " ";
            System.out.print(cur.data + pointer);
            cur = cur.next;
        }
    }

    private boolean isEmptyList() {
        return head == null;
    }

    public void addMultipleNodesToList(List<Integer> elements) {
        for (int data : elements) {
            addNodeToList(data);
        }
    }


    public Node reverseLinkedList() {
        // can we implement using a stack??
        Node current = head;
        Node next = null;
        Node previous = null;
        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
