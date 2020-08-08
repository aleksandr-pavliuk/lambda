package ua.org.alex.lambda.features.parallel_streams;

import ua.org.alex.lambda.features.repo.Person;
import ua.org.alex.lambda.features.repo.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class ParallelStreamUseCase {


    public static void main(String[] args) {
        System.out.println(getHobbiesBySeq());
        System.out.println(getHobbiesByParallel());
    }

    private static List<String> getHobbiesBySeq() {
        long start = System.currentTimeMillis();
        List<String> hobbies = PersonRepository.getAllPersons()
                .stream()
                .map(Person::getHobbies)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println("Sequential Duration :" + (end - start));
        return hobbies;
    }

    private static List<String> getHobbiesByParallel() {
        long start = System.currentTimeMillis();
        List<String> hobbies = PersonRepository.getAllPersons()
                .parallelStream()
                .map(Person::getHobbies)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println("Parallel Duration :" + (end - start));
        return hobbies;
    }
}
