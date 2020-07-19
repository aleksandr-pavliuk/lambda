package ua.org.alex.lambda.features.streams;

import ua.org.alex.lambda.features.repo.Person;
import ua.org.alex.lambda.features.repo.PersonRepository;

import java.util.function.Predicate;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class StreamMapFilterReduceExample {

    private static Predicate<Person> p1 = (per) -> per.getHeight() >= 140;
    private static Predicate<Person> p2 = (per) -> per.getGender().equals("Male");

    public static void main(String[] args) {

        int kidsCount = PersonRepository.getAllPersons()
                .stream()
                .filter(p1.and(p2))
                .map(Person::getKids)
                //.reduce(0,Integer :: sum);
                .reduce(0, (x, y) -> (x + y));
        System.out.println("Number of Kids :" + kidsCount);
    }
}
