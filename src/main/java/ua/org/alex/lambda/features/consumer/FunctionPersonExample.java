package ua.org.alex.lambda.features.consumer;

import ua.org.alex.lambda.features.repo.Person;
import ua.org.alex.lambda.features.repo.PersonRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class FunctionPersonExample {

    private static Function<String, Integer> f1 = name -> name.length();

    private static Predicate<Person> p1 = per -> per.getHeight() >= 140;

    private static Predicate<Person> p2 = per -> per.getGender().equals("Male");

    private static Function<List<Person>, Map<String, Double>> f2 = personList -> {
        Map<String, Double> map = new HashMap<>();
        personList.forEach(per -> {
            if (p1.and(p2).test(per))
                map.put(per.getName(), per.getSalary());
        });
        return map;
    };

    public static void main(String[] args) {

        //System.out.println(f1.apply("java features"));
        List<Person> personList = PersonRepository.getAllPersons();
        Map<String, Double> map = f2.apply(personList);
        System.out.println("Result :" + map);
    }
}
