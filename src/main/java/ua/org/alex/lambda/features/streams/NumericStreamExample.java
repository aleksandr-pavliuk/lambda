package ua.org.alex.lambda.features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class NumericStreamExample {

    private static BinaryOperator<Integer> bo = (x, y) -> x + y;

    private static int calculateSum(List<Integer> l1) {
        return l1.stream().reduce(0, bo);
    }

    private static int calculateSumWithStream(IntStream intStream) {
        return intStream.sum();
    }

    public static void main(String[] args) {

        List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("Total is :" + calculateSum(l1));
        IntStream intStream = IntStream.rangeClosed(1, 6);
        System.out.println("Total Using Stream :" + calculateSumWithStream(intStream));

    }
}
