package ua.org.alex.lambda.features.methodref;

import java.util.function.Consumer;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class LambdaLocalVariable {

    private static int k = 0;

    public static void main(String[] args) {

        int i = 10;

        Consumer<Integer> c1 = (j) -> {
            //i++;
            k = 15;
            System.out.println("Print K:" + k);
            System.out.println("Value is :" + (i + j));
        };

        c1.accept(15);
    }
}
