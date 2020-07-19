package ua.org.alex.lambda.features.streams;

import ua.org.alex.lambda.features.repo.Person;
import ua.org.alex.lambda.features.repo.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class StreamsVsCollectionExample {

    public static void main(String[] args) {

        List<String> names = new ArrayList<String>();
        names.add("John");
        names.add("Adan");
        names.add("Nancy");

        for (String name : names) {
            //System.out.println("Iteration 1 :"+name);
        }

        for (String name : names) {
            //System.out.println("Iteration 2 :"+name);
        }

        Stream<String> stream = names.stream();
        //stream.forEach(p -> System.out.println("<<<< :"+p));
        //stream.forEach(p -> System.out.println("<<<< :"+p));

        List<String> personNames = PersonRepository
                .getAllPersons()
                .stream()
                .peek(per -> System.out.println(per))
                .map(Person::getName)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }
}
