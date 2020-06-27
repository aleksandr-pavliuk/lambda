package ua.org.alex.lambda.features.consumer;

import ua.org.alex.lambda.features.repo.Person;
import ua.org.alex.lambda.features.repo.PersonRepository;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class ConsumerPersonExample {

    static Consumer<Person> c1 = (person) -> System.out.println(person);

    static Consumer<Person> c2 = (person) -> System.out.println(person.getName().toUpperCase());

    static Consumer<Person> c3 = (person) -> System.out.println(person.getHobbies());

    static List<Person> personList = PersonRepository.getAllPersons();

    static void printNameAndHobbies() {
        personList.forEach(c1.andThen(c2));
    }

    private static void printWithCondition() {
        personList.forEach(person -> { // iterate student
        if (person.getGender().equals("Male") && person.getHeight() >= 140){
            c2.andThen(c3).accept(person);
        }
        });
    }

    public static void main(String[] args) {
        //List<Person> personList = PersonRepository.getAllPersons();
        //c1.accept(PersonRepository.getPerson());
        //c2.accept(PersonRepository.getPerson());
        //c3.accept(PersonRepository.getPerson());
        //c1.andThen(c2).andThen(c3).accept(PersonRepository.getPerson());
        //printNameAndHobbies();
        printWithCondition();
    }
}
