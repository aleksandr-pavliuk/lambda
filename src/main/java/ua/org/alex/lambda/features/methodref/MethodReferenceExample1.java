package ua.org.alex.lambda.features.methodref;

import ua.org.alex.lambda.features.repo.Person;
import ua.org.alex.lambda.features.repo.PersonRepository;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class MethodReferenceExample1 {

    private static Function<String, String> f1 = name -> name.toUpperCase();
    private static Function<String, String> f2 = String::toUpperCase;

    private static Predicate<Person> p1 = per -> per.getHeight() >= 140;
    private static Predicate<Person> p2 = MethodReferenceExample1::heightCheck;
    private static BiPredicate<Person, Integer> p3 = MethodReferenceExample1::heightCheckWithParam;
    private static Function<String, String> f3 = MethodReferenceExample1::sayMyName;

    public static void main(String[] args) {

        System.out.println("Lambda Expression Result :" + f1.apply("java8"));
        System.out.println("Method Reference Result :" + f2.apply("java8"));
        System.out.println("Predicate 1 Result :" + p1.test(PersonRepository.getPerson()));
        System.out.println("Predicate 2 Result :" + p2.test(PersonRepository.getPerson()));
        System.out.println("Predicate 3 Result :" + p3.test(PersonRepository.getPerson(), 145));
        System.out.println("Function Test :" + f3.apply("java8"));
    }

    private static boolean heightCheck(Person per) {
        return per.getHeight() >= 140;
    }

    private static boolean heightCheckWithParam(Person per, Integer height) {
        return per.getHeight() >= height;
    }

    private static String sayMyName(String name) {
        return "Hello Mr." + name;
    }
}
