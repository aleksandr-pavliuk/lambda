package ua.org.alex.lambda.features.lambdas;

import java.util.Comparator;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class ComparatorLambdaExample {

    public static void main(String[] args) {
        // Before
        Comparator<Integer> c1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println("Comparator 1 : " + c1.compare(15, 10));

        // After
        Comparator<Integer> c2 = (Integer o1, Integer o2) -> o1.compareTo(o2);
        System.out.println("Comparator 2 : " + c2.compare(15, 10));

        Comparator<Integer> c3 = (o1, o2) -> o1.compareTo(o2);
        System.out.println("Comparator 3 : " + c3.compare(15, 10));
    }
}
