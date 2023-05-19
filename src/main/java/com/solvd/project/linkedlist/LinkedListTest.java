package com.solvd.project.linkedlist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LinkedListTest {
    private static final Logger logger = LogManager.getLogger(LinkedList.class);
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        list.add(10);
        list.add(15);
        list.add(20);
        list.addFront(5);
        list.add(2, 7);

        logger.info(list.toString());

        LinkedList<String> stringList = new LinkedList<>();

        stringList.add("how");
        stringList.add("are");
        stringList.addFront("Hello,");
        stringList.add(2, "test");

        logger.info(stringList.toString());


    }
}
