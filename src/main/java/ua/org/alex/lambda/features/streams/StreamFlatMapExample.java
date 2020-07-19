package ua.org.alex.lambda.features.streams;

import ua.org.alex.lambda.features.repo.Person;
import ua.org.alex.lambda.features.repo.PersonRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class StreamFlatMapExample {

    private static List<String> hobbies(List<Person> personList) {

        return personList.stream()
                .map(Person::getHobbies)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private static List<String> distinctHobbies(List<Person> personList) {

        return personList.stream()
                .map(Person::getHobbies)
                .flatMap(List::stream)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }

    private static long countOfHobbies(List<Person> personsList) {

        return personsList.stream()
                .map(Person::getHobbies)
                .flatMap(List::stream)
                .distinct()
                .count();
    }

    public static void main(String[] args) {

        List<Integer> oddNumbers = Arrays.asList(1, 3, 5, 7);
        List<Integer> evenNumbers = Arrays.asList(2, 4, 6, 8);

        List<List<Integer>> listOfList = Arrays.asList(oddNumbers, evenNumbers);
        System.out.println("Before Flatten :" + listOfList);

        List<Integer> flattenList = listOfList.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
        System.out.println("After Flatten :" + flattenList);

        System.out.println("Hobbies Result with Duplicates :" + hobbies(PersonRepository.getAllPersons()));
        System.out.println("Hobbies Result without Duplicates :" + distinctHobbies(PersonRepository.getAllPersons()));
        System.out.println("Hobbies Count :" + countOfHobbies(PersonRepository.getAllPersons()));
    }
}
