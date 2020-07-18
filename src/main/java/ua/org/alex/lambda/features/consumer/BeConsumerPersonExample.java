package ua.org.alex.lambda.features.consumer;

import ua.org.alex.lambda.features.repo.Person;
import ua.org.alex.lambda.features.repo.PersonRepository;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class BeConsumerPersonExample {

    static void printPersonalDetails() {

        BiConsumer<String, List<String>> personConsumer = (name, hobbies) -> System.out.println(name + " " + hobbies);
        BiConsumer<String, Double> salaryConsumer = (name,salary) -> System.out.println(name +" "+salary);

        List<Person> personList = PersonRepository.getAllPersons();

        //personList.forEach(per -> personConsumer.accept(per.getName(), per.getHobbies()));
        personList.forEach(per -> {
            personConsumer.accept(per.getName(), per.getHobbies());
            salaryConsumer.accept(per.getName(),per.getSalary());
        });
    }

    public static void main(String[] args) {
        printPersonalDetails();
    }

}
