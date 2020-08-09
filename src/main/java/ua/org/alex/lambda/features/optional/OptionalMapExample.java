package ua.org.alex.lambda.features.optional;

import ua.org.alex.lambda.features.repo.Address;
import ua.org.alex.lambda.features.repo.Person;
import ua.org.alex.lambda.features.repo.PersonRepository;

import java.util.Optional;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class OptionalMapExample {

    public static void main(String[] args) {
        optionalMapExample();
        optionalFlatMapExample();
        optionalMapFilterExample();
    }

    private static void optionalMapExample() {
        Optional<Person> per = PersonRepository.getPersonOptional();
        per.ifPresent(person -> {
            String name = per.map(Person::getName).orElse("No Data Found");
            System.out.println("Name :" + name);
        });
    }

    private static void optionalFlatMapExample() {
        Optional<Person> per = PersonRepository.getPersonOptional();
        if (per.isPresent()) {
            Optional<Address> add = per.flatMap(Person::getAddress);
            System.out.println("Address :" + add.get());
        }
    }

    private static void optionalMapFilterExample() {
        Optional<Person> per = PersonRepository.getPersonOptional().filter(person -> person.getHeight() >= 140);
        per.ifPresent(person -> System.out.println(person.getAddress().get()));
    }
}
