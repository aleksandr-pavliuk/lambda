package ua.org.alex.lambda.features.parallel_streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class ParallelWhenNotToUseExample {

    public static void main(String[] args) {
        List<Integer> list = IntStream.rangeClosed(1, 10000).boxed().collect(Collectors.toList());
        sequentialCalculation(list);
        parallelCalculation(list);

    }

    private static int sequentialCalculation(List<Integer> list) {
        long start = System.currentTimeMillis();
        int total = list.stream()
                .reduce(0, (x, y) -> x + y);
        long end = System.currentTimeMillis();
        System.out.println("Sequential Duration :" + (end - start));
        return total;
    }

    private static int parallelCalculation(List<Integer> list) {
        long start = System.currentTimeMillis();
        int total = list.parallelStream()
                .reduce(0, (x, y) -> x + y);
        long end = System.currentTimeMillis();
        System.out.println("Parallel Duration :" + (end - start));
        return total;
    }
}