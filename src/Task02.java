import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        double[] numberList = new double[5];
        int listIndex = 0;

        while (listIndex < numberList.length) {
            System.out.printf("Input #%d number for list", listIndex + 1);
            try {
                numberList[listIndex] = scan.nextDouble();
                listIndex++;
            } catch (InputMismatchException e) {
                System.err.println("Please input a valid number");
                scan.nextLine();
            }
        }

        double max = GET_MAX.apply(numberList);
        double min = GET_MIN.apply(numberList);
        double sum = GET_SUM.apply(numberList);
        double avg = GET_AVG.apply(numberList);
        int count = (int) counter(3).apply(numberList);

        System.out.printf("max: %.2f;\n" + "min: %.2f;\n" + "sum: %.2f;\n" + "avg: %.2f;\n" + "count: %d;\n", max, min, sum, avg, count);
    }

    public static final ArrayProcessor GET_MAX = a -> Arrays.stream(a).max().orElse(Double.NaN);
    public static final ArrayProcessor GET_MIN = a -> Arrays.stream(a).min().orElse(Double.NaN);
    public static final ArrayProcessor GET_SUM = a -> Arrays.stream(a).sum();
    public static final ArrayProcessor GET_AVG = a -> Arrays.stream(a).average().orElse(Double.NaN);

    public static ArrayProcessor counter(double value) {
        return a -> Arrays.stream(a).filter(d -> d == value).count();
    }
}