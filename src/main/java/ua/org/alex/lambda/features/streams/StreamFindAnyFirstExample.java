package ua.org.alex.lambda.features.streams;

import ua.org.alex.lambda.features.repo.Person;
import ua.org.alex.lambda.features.repo.PersonRepository;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class StreamFindAnyFirstExample {

    private static Predicate<Person> p2 = per -> per.getHeight() >= 200;
    private static Predicate<Person> p3 = per -> per.getGender().equals("Female");

    public static void main(String[] args) {
        Optional<Person> findAny = findAny();
        if (findAny.isPresent())
            System.out.println("Find Any Result :" + findAny.get());
        else
            System.out.println("No Record Found");
        Optional<Person> findFirst = findFirst();
        if (findFirst.isPresent())
            System.out.println("Find First Result :" + findFirst().get());
        else
            System.out.println("No Record Found");

    }

    private static Optional<Person> findAny() {
        return PersonRepository.getAllPersons()
                .stream()
                .filter(p2)
                .findAny();
    }

    private static Optional<Person> findFirst() {
        return PersonRepository.getAllPersons()
                .stream()
                .filter(p3)
                .findFirst();
    }
}
