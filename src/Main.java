import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> testArray = Arrays.asList("Blah", "test", "465", "Samplevalue", "SAMPLEVALUE", "a");
        List<Integer> testIntArray = Arrays.asList(4, 54, 100, 54, 150, 401);

        List<String> longerThanFour = allMatches(testArray, word -> word.length() > 4);
        System.out.println(longerThanFour);

        List<String> startWithCapital = allMatches(testArray, word -> Character.isUpperCase(word.charAt(0)));
        System.out.println(startWithCapital);

        List<Integer> containsZeroes = allMatches(testIntArray, num -> String.valueOf(num).contains("0"));
        System.out.println(containsZeroes);

        List<String> exclamationMarkOnThirdIndex = transformedList(testArray, word -> {
            if (word.length() > 2) {
                word = word.substring(0, 2) + "!" + word.substring(2);
            }
            return word;
        });
        System.out.println(exclamationMarkOnThirdIndex);

        List<Integer> addFive = transformedList(testIntArray, num -> num + 5);
        System.out.println(addFive);

//        List<Integer> wordLengths = transformedList(testArray, String::length);
        // ??
    }

    public static <T> List<T> allMatches(List<T> list, Predicate<T> predicate) {
        return list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static <T> List<T> transformedList(List<T> list, Function<T, T> function) {
        return list.stream()
                .map(function)
                .collect(Collectors.toList());

    }
}
