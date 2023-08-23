package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
           return 0;
        }
        String[] tokens = getTokensByCustomDelimiter(text);
        if(tokens == null) {
            tokens = text.split(",|:");
        }
        List<Integer> numbers = getNumbers(tokens);
        validateNegativeNumber(numbers);
        return addNumbers(numbers);
    }

    private static String[] getTokensByCustomDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return null;
    }

    private static List<Integer> getNumbers(String[] tokens) {
        return Arrays.stream(tokens)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateNegativeNumber(List<Integer> numbers) {
        boolean existNegative = numbers.stream()
                .anyMatch(number -> number < 0);
        if (existNegative) {
         throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    private static int addNumbers(List<Integer> numbers){
        int result = 0;
        for (Integer number : numbers) {
            result += number;
        }
        return result;
    }
}
