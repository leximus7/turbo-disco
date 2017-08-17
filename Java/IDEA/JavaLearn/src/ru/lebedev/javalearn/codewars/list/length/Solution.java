package ru.lebedev.javalearn.codewars.list.length;

class Solution {
    static int length(Node head) {
        Node node = head;
        int length = 0;

        while (node != null) {
            node = node.next;
            length++;
        }

        return length;
    }
}


class Node {
    public Object data;
    public Node next;

    Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(Object data) {
        this(data, null);
    }
}