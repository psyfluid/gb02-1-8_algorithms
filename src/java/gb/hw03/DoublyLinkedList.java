package gb.hw03;

import java.util.Collection;

public class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
    }

    public DoublyLinkedList(Collection<Integer> c) {
        this();
        addAll(c);
    }

    private void addAll(Collection<Integer> c) {
        for (Integer num : c) {
            this.add(num);
        }
    }

    public void add(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else if (tail != null) {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
    }

    public void add(int value, Node node) {
        Node next = node.next;
        Node newNode = new Node(value);
        node.next = newNode;
        newNode.prev = node;
        if (next == null) {
            tail = newNode;
        } else {
            next.prev = newNode;
            newNode.next = next;
        }
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        if (prev == null) {
            next.prev = null;
            head = next;
        } else if (next == null) {
            prev.next = null;
            tail = prev;
        } else {
            prev.next = next;
            next.prev = prev;
        }
    }

    public Node find(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value)
                return current;
            current = current.next;
        }
        return null;
    }

    public void reverse() {
        Node current = head;
        while (current != null) {
            Node next = current.next;
            Node prev = current.prev;
            current.next = prev;
            current.prev = next;

            if (prev == null) tail = current;
            if (next == null) head = current;
            current = next;
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("[");
        Node current = head;
        while (current != null) {
            sb.append(current.value);
            if (current != tail) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static class Node {
        int value;
        Node next;
        Node prev;

        public Node() {
            next = prev = null;
        }

        public Node(int value) {
            this();
            this.value = value;
        }
    }
}
