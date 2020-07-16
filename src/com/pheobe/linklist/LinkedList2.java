package com.pheobe.linklist;

/**
 * CSCI 1110
 *
 * @author ASiegel
 */

/**
 * A listnked list is a sequence of nodes with efficient element
 * insertion and removal. This class contains a subset of the methods
 * of the standard java.util.LinkedList class.
 *
 * You will finish off the contains method.
 */

public class LinkedList2 {
    //attributes
    private Node head;
    private Node tail;

    //Node
    class Node {
        public Object data;
        public Node previous;
        public Node next;
    }

    /**
     * Constructs an empty linked list/
     */
    public LinkedList2() {
        head = null;
        tail = null;
    }


    /**
     * @method remove()
     * @param data : object to be removed
     * @returns void
     *
     * Removes node from the linked list
     */


    //PLEASE START WORK HERE
    //===============================================
    public void remove(Object data) {
        if (head == null) {
            return;
        }
        Node p = head;
        while (p != null) {
            if (p.data.equals(data)) {
                break;
            }
            p = p.next;
        }
        if (p != null) {// find the 'data' element
            Node previous = p.previous;
            Node next = p.next;
            if (previous != null) {
                previous.next = next;
            } else {
                head = next;
            }
            if (next != null) {
                next.previous = previous;
            } else {
                tail = previous;
            }
            p.previous = p.next = null;
        }


    }

    //===============================================
    //PLEASE END WORK HERE


    /**
     * Appends a new node to the end of the linked list.
     */
    public void append(Object element) {
        if (head == null) //Empty linked list
        {
            Node firstNode = new Node();
            firstNode.data = element;
            firstNode.previous = null;
            firstNode.next = null;
            head = firstNode;
            tail = firstNode;
        } else //At least one node already exists.
        {
            Node newNode = new Node();
            newNode.data = element;
            newNode.previous = tail;
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
        }
    }


    public String toString() {
        Node position = head;
        String output = "";
        while (position != null) {
            output += position.data + "\n";
            position = position.next;
        }
        return output;
    }
}
