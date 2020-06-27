package ua.org.alex.lambda.features;

import java.util.stream.IntStream;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class Java7VsJava8Example {
    public static void main(String[] args) {
        // Before
        int total = 0;
        for (int i = 0; i <= 50; i++) {
            total += i;
        }
        System.out.println("Total is : " + total);

        //After
        int total2 = IntStream.rangeClosed(0, 50)
                .map(Integer::new)
                .sum();
        System.out.println("Total in Java8 : " + total2);
    }

}
