package ua.org.alex.lambda.features.consumer;

import ua.org.alex.lambda.features.repo.Person;
import ua.org.alex.lambda.features.repo.PersonRepository;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class SupplierExample {

    private static Supplier<Person> s1 = () -> PersonRepository.getPerson();
    private static Supplier<List<Person>> s2 = () -> PersonRepository.getAllPersons();

    public static void main(String[] args) {

        System.out.println("Result :"+s1.get());
        System.out.println("Result :"+s2.get());
    }
}
