package ua.org.alex.lambda.features;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
@FunctionalInterface
public interface TestInterface {
    public void add();

    default String sayHi() {
        return "Hi";
    }

    static boolean isTrue() {
        return true;
    }
}
