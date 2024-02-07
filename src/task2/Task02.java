package task2;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {

        // CREATE ARRAY OF 5 ELEMENTS
        Scanner scan = new Scanner(System.in);
        double[] numberList = new double[5];
        int listIndex = 0;

        // PROMPT USER TO ENTER VALUE OF ARRAY
        while (listIndex < numberList.length) {
            System.out.printf("Input #%d number for list\n", listIndex + 1);
            try {
                numberList[listIndex] = scan.nextDouble();
                listIndex++;
            } catch (InputMismatchException e) {
                System.err.println("Please input a valid number");
                scan.nextLine();
            }
        }

        // PROMPT USER ENTER OCCURRENCES CHECK NUMBER
        System.out.println("Which value do you want to check for occurrences?");
        double value = scan.nextDouble();

        // USING LAMBDA EXPRESSION TO RETURN MAX, MIN, SUM, AVG
        double max = GET_MAX.apply(numberList);
        double min = GET_MIN.apply(numberList);
        double sum = GET_SUM.apply(numberList);
        double avg = GET_AVG.apply(numberList);

        // USING LAMBDA EXPRESSION METHOD TO RETURN OCCURRANCES
        int count = (int) counter(value).apply(numberList);

        // PRINT THE OUTPUT
        System.out.printf("Maixmum value: %.2f;\n" +
                "Minimum value: %.2f;\n" +
                "Sum of all values: %.2f;\n" +
                "Average of values: %.2f;\n" +
                "Number of occurrences of %.2f: %d;\n", max, min, sum, avg, value, count);
    }

    // DEFINE VARIABLES OF ArrayProcessor
    public static final ArrayProcessor GET_MAX = a -> Arrays.stream(a).max().orElse(Double.NaN);
    public static final ArrayProcessor GET_MIN = a -> Arrays.stream(a).min().orElse(Double.NaN);
    public static final ArrayProcessor GET_SUM = a -> Arrays.stream(a).sum();
    public static final ArrayProcessor GET_AVG = a -> Arrays.stream(a).average().orElse(Double.NaN);

    // DEFINE FUNCTION RETURNS AN ArrayProcessor THAT COUNTS THE OCCURRANCES 
    public static ArrayProcessor counter(double value) {
        return a -> Arrays.stream(a).filter(d -> d == value).count();
    }
}
    
