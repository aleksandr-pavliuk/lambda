package ua.org.alex.lambda.features.consumer;

import ua.org.alex.lambda.features.repo.Person;
import ua.org.alex.lambda.features.repo.PersonRepository;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class ConsumerPredicateExample {

    private static Predicate<Person> p1 = per -> per.getHeight() >= 140;

    private static Predicate<Person> p2 = per -> per.getGender().equals("Male");

    private static BiPredicate<Integer, String> p3 = (height, gender) -> height >= 140 && gender.equals("Male");

    private static BiConsumer<String, List<String>> hobbiesConsumer = (name, hobbies) -> System.out
            .println(name + " " + hobbies);

    private static Consumer<Person> personConsumer = per -> {
        //if (p1.and(p2).test(per)){
        if(p3.test(per.getHeight(), per.getGender())){
            hobbiesConsumer.accept(per.getName(), per.getHobbies());
        }
    };


    public static void main(String[] args) {

        List<Person> personList = PersonRepository.getAllPersons();
        personList.forEach(personConsumer);
    }
}
