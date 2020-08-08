package ua.org.alex.lambda.features.terminal_streams;

import ua.org.alex.lambda.features.repo.Person;
import ua.org.alex.lambda.features.repo.PersonRepository;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class StreamJoiningExample {

    private static String joiningExample() {
        return PersonRepository.getAllPersons()
                .stream()
                .map(Person::getName)
                //.collect(Collectors.joining());
                //.collect(Collectors.joining("-"));
                .collect(Collectors.joining("-","[","]"));
    }

    public static void main(String[] args) {
        char[] ch = {'a', 'b', 'c', 'd', 'e'};
        String join = Stream.of(ch).map(arr -> new String(arr)).collect(Collectors.joining("-", "[", "]"));
        System.out.println("Joined Data :" + join);
        System.out.println("Joining Output :"+joiningExample());
    }
}
