import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        double[] numberList = new double[5];
        int count = 0;

        while (count < numberList.length) {
            System.out.printf("Input #%d number for list", count + 1);
            try {
                numberList[count] = scan.nextDouble();
                count ++;
            } catch (InputMismatchException e) {
                System.err.println("Please input a valid number");
                scan.nextLine();
            }
        }

        double max = GET_MAX.apply(numberList);
        double min = GET_MIN.apply(numberList);
        double sum = GET_SUM.apply(numberList);
        double avg = GET_AVG.apply(numberList);

        System.out.printf("max: %.2f;\n" +
                "min: %.2f;\n" +
                "sum: %.2f;\n" +
                "avg: %.2f;\n", max, min, sum, avg
        );
   }

    public static final ArrayProcessor GET_MAX = a -> Arrays.stream(a).max().orElse(Double.NaN);
    public static final ArrayProcessor GET_MIN = a -> Arrays.stream(a).min().orElse(Double.NaN);
    public static final ArrayProcessor GET_SUM = a -> Arrays.stream(a).reduce(0, Double::sum);
    public static final ArrayProcessor GET_AVG = a -> Arrays.stream(a).average().orElse(Double.NaN);

}