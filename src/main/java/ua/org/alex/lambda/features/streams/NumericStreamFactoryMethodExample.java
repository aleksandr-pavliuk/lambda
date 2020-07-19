package ua.org.alex.lambda.features.streams;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class NumericStreamFactoryMethodExample {

    public static void main(String[] args) {
        IntStream intStream1 = IntStream.rangeClosed(1, 6);
        IntStream intStream2 = IntStream.range(1, 6);
        intStream1.forEach(System.out::println);
        System.out.println("------------------");
        intStream2.forEach(System.out::println);


        System.out.println("------------------");
        LongStream.rangeClosed(1, 4).forEach(System.out::println);
        System.out.println("------------------");
        LongStream.rangeClosed(1, 4).asDoubleStream().forEach(System.out::println);
        DoubleStream ds = LongStream.rangeClosed(1, 4).asDoubleStream();

    }
}
