package ua.org.alex.lambda.features.optional;

import ua.org.alex.lambda.features.repo.Person;
import ua.org.alex.lambda.features.repo.PersonRepository;

import java.util.Optional;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class OptionalExample {

    public static void main(String[] args) {
        System.out.println("Result :"+myName("John"));
        Optional<String> name = Optional.ofNullable(myName("John"));
        String name1 = Optional.ofNullable(myName("John")).get();
        System.out.println(name.isPresent() ? name.get():"No Data Found");
        System.out.println("Person Name :"+personName(new Person()));
        Optional<String> personName = personNameWithOptional(PersonRepository.getPersonOptional());
        System.out.println("The Optional Person Name is :" + personName.get());

    }

    private static String myName(String name) {
        return name;
    }

    private static String personName(Person per) {
        if (per != null)
            return per.getName();
        else
            return "No Data Found";
    }

    private static Optional<String> personNameWithOptional(Optional<Person> per) {
        if (per.isPresent())
            return per.map(Person::getName);
        else
            return Optional.empty();
    }
}
