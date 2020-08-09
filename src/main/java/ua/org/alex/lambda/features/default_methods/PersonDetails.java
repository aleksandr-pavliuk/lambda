package ua.org.alex.lambda.features.default_methods;

import ua.org.alex.lambda.features.repo.Person;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public interface PersonDetails {
    double calculateTotalSalary(List<Person> personList);

    default int totalKids(List<Person> personList) {
        return personList.stream().map(Person::getKids).reduce(0, (x, y) -> x + y);
    }

    static List<String> personNames(List<Person> personList) {
        return personList.stream().map(Person::getName).collect(Collectors.toList());
    }
}
