package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SpeedGenerator {
    public static List<Integer> generateSpeeds(int length) {
        return IntStream.range(0, length)
                .map(i -> generateSpeed())
                .boxed()  // int 값을 Integer 객체로 변환
                .collect(Collectors.toList());
    }

    public static int generateSpeed(){
        return (int) (Math.random() * 10);
    }
}
