package com.pheobe.linklist;

/**
 * A listnked list is a sequence of nodes with efficient element
 * insertion and removal. This class contains a subset of the methods
 * of the standard java.util.LinkedList class.
 *
 * You will finish off the contains method.
 */

public class LinkedList38
{
    //attributes
    private Node head;
    private Node tail;

    //Node
    class Node
    {
        public Object data;
        public Node previous;
        public Node next;
    }

    /**
     * Constructs an empty linked list/
     */
    public LinkedList38()
    {
        head = null;
        tail = null;
    }

    /**
     * Appends a new node to the end of the linked list.
     */
    public void append(Object element)
    {
        if (head == null) //Empty linked list
        {
            Node firstNode = new Node();
            firstNode.data = element;
            firstNode.previous = null;
            firstNode.next = null;
            head = firstNode;
            tail = firstNode;
        }
        else //At least one node already exists.
        {
            Node newNode = new Node();
            newNode.data = element;
            newNode.previous = tail;
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
        }
    }

    //PLEASE START WORK HERE
    //===============================================

    /**
     * Check to see if element is contained
     * anywhere in the linked list.
     * @returns boolean: true if contained
     */
    public boolean contains(Object element) {
        if (head == null) {// empty linked list
            return false;
        }
        Node p = head;
        while (p != null) {
            if (p.data.equals(element)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }




    //===============================================
    //PLEASE END WORK HERE

}