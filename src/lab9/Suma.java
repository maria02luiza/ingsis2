package lab9;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Suma {
    public static void main(String[] args) {
        Random random=new Random();
        List<Integer> randomNumbers = IntStream.range(0,10)
                .map(i -> random.nextInt(5,25))
                .boxed()
                .collect(Collectors.toList());
        System.out.println("numerele:"+ randomNumbers);

        int sum=randomNumbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("suma:"+sum);

        int maxVal=randomNumbers.stream()
                .max((n1,n2)-> n1>n2 ? 1:-1)
                .get();
        System.out.println("max:"+maxVal);

        int minVal=randomNumbers.stream()
                .min((n1,n2)-> n1>n2 ? 1:-1)
                .get();
        System.out.println("max:"+minVal);
    }

}
