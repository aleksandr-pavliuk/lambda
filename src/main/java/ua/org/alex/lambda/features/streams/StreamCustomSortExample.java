package ua.org.alex.lambda.features.streams;

import ua.org.alex.lambda.features.repo.Person;
import ua.org.alex.lambda.features.repo.PersonRepository;

import java.util.Comparator;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class StreamCustomSortExample {

    public static void main(String[] args) {

        System.out.println("Sort By Name");
        PersonRepository.getAllPersons().stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);

        System.out.println("Sort By Height");
        PersonRepository.getAllPersons().stream()
                .sorted(Comparator.comparing(Person::getHeight))
                .forEach(System.out::println);

        System.out.println("Reverse Sort By Name");
        PersonRepository.getAllPersons().stream()
                .sorted(Comparator.comparing(Person::getName).reversed())
                .forEach(System.out::println);
    }
}
