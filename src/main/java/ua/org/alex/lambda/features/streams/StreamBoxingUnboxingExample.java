package ua.org.alex.lambda.features.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class StreamBoxingUnboxingExample {

    private static List<Integer> boxingMethod() {
        return IntStream.rangeClosed(1, 40) // primitive int
                .boxed() // converting to wrapper Integer
                .collect(Collectors.toList()); // collect as List
    }

    private static int calculateSum(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue) // Map do the converting part
                .sum(); // performing sum operation
    }

    public static void main(String[] args) {
        boxingMethod().forEach(System.out::println);

        System.out.println("Sum is :" + calculateSum(boxingMethod()));
    }
}
