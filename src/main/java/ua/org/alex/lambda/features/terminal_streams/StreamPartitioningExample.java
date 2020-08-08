package ua.org.alex.lambda.features.terminal_streams;

import ua.org.alex.lambda.features.repo.Person;
import ua.org.alex.lambda.features.repo.PersonRepository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.partitioningBy;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class StreamPartitioningExample {

    private static Predicate<Person> p1 = per -> per.getHeight() >= 140;

    private static void byHeight() {
        Map<Boolean, List<Person>> map = PersonRepository.getAllPersons()
                .stream()
                .collect(partitioningBy(p1));
        System.out.println("Person Map 1:" + map);
    }

    private static void byHeightWith2Param() {
        Map<Boolean, Set<Person>> map = PersonRepository.getAllPersons()
                .stream()
                .collect(partitioningBy(p1, Collectors.toSet()));
        System.out.println("Person Map 2:" + map);
    }

    private static void byHeightWithMap() {
        Map<Boolean, Map<String, List<String>>> map = PersonRepository.getAllPersons()
                .stream()
                .collect(partitioningBy(p1, Collectors.toMap(Person::getName, Person::getHobbies)));
        System.out.println("Person Map 3:" + map);
    }

    public static void main(String[] args) {
        //byHeight();
        //byHeightWith2Param();
        byHeightWithMap();
    }
}
