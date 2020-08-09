package ua.org.alex.lambda.features.default_methods;

import ua.org.alex.lambda.features.repo.Person;
import ua.org.alex.lambda.features.repo.PersonRepository;

import java.util.List;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class PersonDetailClient {

    private static List<Person> listOfPersons = PersonRepository.getAllPersons();


    public static void main(String[] args) {
        PersonDetails pd = new PersonDetailImpl();
        System.out.println("Total Salary :" + pd.calculateTotalSalary(listOfPersons));
        System.out.println("Total Kids Count :" + pd.totalKids(listOfPersons));
        PersonDetails.personNames(listOfPersons).forEach(System.out::println);
        PersonDetailImpl.personNames(listOfPersons).forEach(System.out::println);
    }

}
