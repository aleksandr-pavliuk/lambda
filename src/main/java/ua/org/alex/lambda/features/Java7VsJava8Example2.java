package ua.org.alex.lambda.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class Java7VsJava8Example2 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Sam", "Peter", "Ivan", "Sam");

        //Before
        List<String> uniqNames = new ArrayList<>();
        for (String name:
             names) {
            if (!uniqNames.contains(name)){
                uniqNames.add(name);
            }
        }
        System.out.println("Unique List " + uniqNames);

        //After
        List<String> uniqNames2 = names.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique List in Java 8 " + uniqNames2);
    }
}
