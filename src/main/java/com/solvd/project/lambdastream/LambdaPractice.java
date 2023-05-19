package com.solvd.project.lambdastream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaPractice {
    private final static Logger logger = LogManager.getLogger(LambdaPractice.class);
    public static void main(String[] args) {
        // Use of consumer
        List<String> list = Arrays.asList("Hello", "how", "are", "you");
        forEach(list, x -> logger.info(x + "\n"));

        // Use of predicate
        List<Integer> numsList = Arrays.asList(5, 10, 15, 20, 30, 40, 50, 60, 70, 80, 90, 100);
        filter(numsList, x -> x < 50);
        logger.info("------------------------\n");
        filter(numsList, i -> i >= 80);
        logger.info("---------------------------------\n");
        // Use of BiFunction
        logger.info(calculate((x,y) -> x * y, 10, 5) + " calculate\n");
        logger.info(calculate((x,y) -> x + y, 5, 25) + " sum\n");

        // Stream practice
        List<Integer> numsListSquared = numsList.stream().map(x -> x*x).toList();
        logger.info("------------------------\n");
        forEach(numsListSquared, x -> logger.info(x + "\n"));
        logger.info("------------------------\n");
        forEach(list.stream().filter(x -> x.startsWith("a")).toList(), s -> logger.info(s + "\n"));
        logger.info("------------------------\n");

        List<String> bingoNumbers = Arrays.asList("B10", "B05", "B02",
                "N10", "N12", "N17",
                "G01", "G04");
        bingoNumbers.stream()
                .map(String::toLowerCase)
                .filter(s -> s.startsWith("g"))
                .sorted()
                .forEach(s -> logger.info(s + "\n"));
    }
    static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for(T t : list) {
            consumer.accept(t);
        }
    }
    static void filter(List<Integer> list, Predicate<Integer> predicate) {
        for(Integer num : list) {
            if(predicate.test(num)) {
                logger.info(num + "\n");
            }
        }
    }
    static Integer calculate(BiFunction<Integer, Integer, Integer> function, Integer x, Integer y) {
        return function.apply(x,y);
    }
}
