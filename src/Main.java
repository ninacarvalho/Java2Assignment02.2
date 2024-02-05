import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] ds = {3.4, 23.5, 1.1, 345.4, 34.1, 12};

        final ArrayProcessor getMax = a -> Arrays.stream(a).max().orElse(Double.NaN);
        final ArrayProcessor getMin = a -> Arrays.stream(a).min().getAsDouble();
        final ArrayProcessor getSum = a -> Arrays.stream(a).reduce(0, Double::sum);
        final ArrayProcessor getAvg = a -> Math.round(Arrays.stream(a).average().orElse(Double.NaN));

        double max = getMax.apply(ds);
        double min = getMin.apply(ds);
        double sum = getSum.apply(ds);
        double avg = getAvg.apply(ds);

        System.out.println("max: " + max + ";\n" +
                "min: " + min + ";\n" +
                "sum: " + sum + ";\n" +
                "avg: " + avg + ";\n"
        );
       }
}