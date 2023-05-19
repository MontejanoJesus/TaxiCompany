package com.solvd.project.linkedlist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LinkedList <T>{
    private static final Logger logger = LogManager.getLogger(LinkedList.class);
    private Integer size = 0;
    private Node<T> head;
    private Node<T> tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(T data) {
        Node<T> temp = new Node<>(data);
        // check for empty list
        if(head == null) {
            head = temp;
            tail = head;
        } else {
            tail.setNext(temp);
            tail = temp;
        }
        size++;
    }

    public void add(Integer position, T data) {
        if(position > size + 1) {
            logger.error("Out of range!");
        }
        Node<T> traversal = head;
        Node<T> previous = new Node<>(null);
        while(position - 1 > 0) {
            previous = traversal;
            traversal = traversal.getNext();

            position--;
        }
        previous.setNext(new Node<>(data));
        previous.getNext().setNext(traversal);
    }

    public void addFront(T data) {
        Node<T> newNode = new Node<>(data);

        newNode.setNext(head);
        head = newNode;

        size++;
    }

    public String toString() {
        String result = "{ ";
        Node<T> temp = head;
        if(temp == null) {
            return result + " }";
        }
        while(temp.getNext() != null) {
            result += String.valueOf(temp.getData()) + " -> ";
            temp = temp.getNext();
        }
        result += String.valueOf(temp.getData());
        return result + " }";

    }
}
