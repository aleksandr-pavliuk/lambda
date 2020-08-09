package ua.org.alex.lambda.features.optional;

import ua.org.alex.lambda.features.repo.Person;
import ua.org.alex.lambda.features.repo.PersonRepository;

import java.util.Optional;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class OptionalIfElseExample {

    public static void main(String[] args) {
        orElse();
        orElseGet();
        orElseThrow();
    }

    private static void orElse() {
        Optional<Person> person = PersonRepository.getPersonOptional();
        //String name = person.isPresent() ? person.get().getName() : "Data Not Found";
        String name = person.map(Person::getName).orElse("Data Not Found");
        System.out.println("OrElse Person Name :" + name);
    }

    private static void orElseGet() {
        Optional<Person> person = PersonRepository.getPersonOptional();
        String name = person.map(Person::getName).orElseGet(() -> {
            // to send a notification mail
            // Initiate any script
            return "Data Not Found";
        });
        System.out.println("OrElseGet Person Name :" + name);
    }

    private static void orElseThrow() {
        Optional<Person> person = PersonRepository.getPersonOptional();
        //String name = person.isPresent() ? person.get().getName() : "Data Not Found";
        String name = person.map(Person::getName).orElseThrow(() -> new RuntimeException("Name Not Found"));
        System.out.println("OrElse Person Name :" + name);
    }
}
