package lambda;

import java.util.stream.IntStream;

public class TestDemo {

    public static void main(String[] args) {
        int[] nums = {33, 44, -55, 66};
        int asInt = IntStream.of(nums).min().getAsInt();
        System.out.print("min = ");
    }
}
