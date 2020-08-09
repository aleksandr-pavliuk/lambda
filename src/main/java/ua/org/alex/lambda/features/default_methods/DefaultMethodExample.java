package ua.org.alex.lambda.features.default_methods;

import ua.org.alex.lambda.features.repo.Person;
import ua.org.alex.lambda.features.repo.PersonRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class DefaultMethodExample {

    public static void main(String[] args) {
        List<String> nameList = PersonRepository.getAllPersons()
                .stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println("Before Sort");
        nameList.forEach(name -> System.out.println(name));
        Collections.sort(nameList);
        System.out.println("After Sort");
        nameList.forEach(name -> System.out.println(name));
        System.out.println("Natural Order");
        nameList.sort(Comparator.naturalOrder());
        nameList.forEach(name -> System.out.println(name));
        System.out.println("Reverse Order");
        nameList.sort(Comparator.reverseOrder());
        nameList.forEach(name -> System.out.println(name));
    }
}
