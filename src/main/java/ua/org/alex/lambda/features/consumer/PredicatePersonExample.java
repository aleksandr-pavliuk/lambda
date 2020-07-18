package ua.org.alex.lambda.features.consumer;

import ua.org.alex.lambda.features.repo.Person;
import ua.org.alex.lambda.features.repo.PersonRepository;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class PredicatePersonExample {

    private static Predicate<Person> p1 = per -> per.getHeight() >= 140;

    private static Predicate<Person> p2 = per -> per.getGender().equals("Male");

    public static void main(String[] args) {

        List<Person> personList = PersonRepository.getAllPersons();

        personList.stream()
                .filter(p1)
                .collect(Collectors.toList());

        personList.forEach(per -> {
            if(p1.and(p2).test(per)){
                System.out.println(per);
            }
        });
    }
}
