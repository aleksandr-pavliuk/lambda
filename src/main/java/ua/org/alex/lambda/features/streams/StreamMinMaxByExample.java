package ua.org.alex.lambda.features.streams;

import ua.org.alex.lambda.features.repo.Person;
import ua.org.alex.lambda.features.repo.PersonRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class StreamMinMaxByExample {

    private static Optional<Person> getTallestPerson() {

        return PersonRepository.getAllPersons()
                .stream()
                .collect(Collectors.maxBy(Comparator.comparing(Person::getHeight)));
    }

    private static Optional<Person> getShortestPerson() {

        return PersonRepository.getAllPersons()
                .stream()
                .collect(Collectors.minBy(Comparator.comparing(Person::getHeight)));
    }

    private static List<Person> filterMultiplePersons() {
        List<Person> personList = new ArrayList<Person>();
        Optional<Person> maxHeight = getTallestPerson();
        Person per = maxHeight.isPresent() ? maxHeight.get() : null;
        if (per != null) {
            personList = PersonRepository.getAllPersons()
                    .stream()
                    .filter(person -> person.getHeight() == per.getHeight())
                    .collect(Collectors.toList());
        }
        return personList;
    }

    public static void main(String[] args) {

        System.out.println("Tallest Person :" + getTallestPerson().get());
        System.out.println("Shortest Person :" + getShortestPerson().get());
        System.out.println("Tallest Group :" + filterMultiplePersons());
    }
}
