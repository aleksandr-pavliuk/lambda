package ua.org.alex.lambda.features.terminal_streams;

import ua.org.alex.lambda.features.repo.Person;
import ua.org.alex.lambda.features.repo.PersonRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class StreamSumAvgExample {
    private static int sumTotalKids() {
        return PersonRepository.getAllPersons()
                .stream()
                .collect(Collectors.summingInt(Person::getKids));
    }

    private static double averageHeight() {
        return PersonRepository.getAllPersons()
                .stream()
                .collect(Collectors.averagingInt(Person::getHeight));
    }

    public static void main(String[] args) {
        System.out.println("Total Kids :" + sumTotalKids());
        System.out.println("Average Height is:" + averageHeight());
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6);
        int total = intList.stream().collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Total :" + total);
    }
}
