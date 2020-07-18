package ua.org.alex.lambda.features.consumer;

import ua.org.alex.lambda.features.repo.Person;
import ua.org.alex.lambda.features.repo.PersonRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class BiFunctionExample {

    private static BiFunction<String, String, String> bf1 = (a, b) -> (a + " " + b);

    private static Predicate<Person> p1 = per -> per.getHeight() >= 140;

    private static Predicate<Person> p2 = per -> per.getGender().equals("Male");

    private static BiFunction<List<Person>, Predicate<Person>, Map<String, Double>> bf2 = (listOfPersons, predicate) -> {
        Map<String, Double> map = new HashMap<>();
        listOfPersons.forEach(per -> {
            if (p1.and(predicate).test(per)) {
                map.put(per.getName(), per.getSalary());
            }
        });
        return map;
    };

    public static void main(String[] args) {

        //System.out.println("Result :" + bf1.apply("java", "features"));
        List<Person> personList = PersonRepository.getAllPersons();
        Map<String, Double> map = bf2.apply(personList, p2);
        System.out.println("Result :" + map);
    }
}
