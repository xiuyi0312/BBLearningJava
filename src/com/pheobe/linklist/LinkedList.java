package com.pheobe.linklist;

/**
 * CSCI 1110
 *
 * @author ASiegel
 */

import java.util.NoSuchElementException;

/**
 * A listnked list is a sequence of nodes with efficient element
 * insertion and removal. This class contains a subset of the methods
 * of the standard java.util.LinkedList class.
 *
 * You will finish off the contains method.
 */

public class LinkedList {
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
    public LinkedList() {
        head = null;
        tail = null;
    }


    /**
     * Remove node from head of the linked list
     * @returns Object: head node of the linked list
     */

    public Object removeHead() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Object removedElement = head.data;
        head = head.next;
        return removedElement;
    }


    //PLEASE START WORK HERE
    //===============================================

    /**
     * @method removeTail()
     * Remove node from tail of the linked list
     * @returns Object: tail node of the linked list
     */


    public Object removeTail() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        if (head == tail) {
            Object removedElement = tail.data;
            tail = head = null;
            return removedElement;
        } else {
            Object removedElement = tail.data;
            Node p = tail.previous;
            p.next = null;
            tail.previous = null;
            tail = p;
            return removedElement;
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
