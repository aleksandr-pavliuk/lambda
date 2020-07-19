package ua.org.alex.lambda.features.streams;

import ua.org.alex.lambda.features.repo.Person;
import ua.org.alex.lambda.features.repo.PersonRepository;

import java.util.Optional;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class StreamReduceExample1 {

    public static void main(String[] args) {

        combineNames();
        Optional<Person> tallestPerson = getTallestPerson();
        System.out.println("Tallest Person is :" + tallestPerson.get());
    }

    private static void combineNames() {
        String names = PersonRepository.getAllPersons()
                .stream()
                .map(Person::getName)
                .reduce("", (a, b) -> a.concat(b));
        System.out.println("Names are :" + names);
    }

    private static Optional getTallestPerson() {

        return PersonRepository.getAllPersons()
                .stream()
                .reduce((x, y) -> (x.getHeight() > y.getHeight() ? x : y));
    }
}
