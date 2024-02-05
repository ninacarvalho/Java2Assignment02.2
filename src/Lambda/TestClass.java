package Lambda;

import java.util.Scanner;

public class TestClass{
	
	// 1. find the maximum value in the array
	public static final ArrayProcessor FIND_MAX = (double[] array) -> {

		double max = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		return max;
	};
	
	// 2. find the minimum value in an array
	public static final ArrayProcessor FIND_MIN = (double[] array)-> {
		double min = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i] < min) {
				min = array[i];
			}
		}
		return min;
	};
	
	// 3. find the sum of the values in the array
	public static final ArrayProcessor FIND_SUM = (double[] array)-> {
		double sum = 0;
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	};
	
	// 4. find the average of the values in the array
	public static final ArrayProcessor FIND_AVG = (double[] array)-> {
		double sum = 0, average;
		
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		average = sum / array.length;
		return average;
	};
	
	public static void main(String[] args) {
		
		Scanner kbd = new Scanner(System.in);
		
		double[] array = new double[5];
		
		for(int i = 0; i < array.length; i++) {
			System.out.print("Input number for " + (i + 1) + ": ");
			array[i] = kbd.nextDouble();
		}
		
		System.out.println("Minimum of array: " + FIND_MIN.apply(array));
		System.out.println("Maximum of array: " + FIND_MAX.apply(array));
		System.out.println("Sum of array: " + FIND_SUM.apply(array));
		System.out.println("Average of array: " + FIND_AVG.apply(array));
		
		System.out.print("\nEnter a number: ");
		double findNumber = kbd.nextDouble();
		
		System.out.println("Count of the number: " + counter(findNumber).apply(array));
	}
	
	public static ArrayProcessor counter(double value) {
		
		ArrayProcessor countEqual = (double[] array) -> {
			int count = 0;
			for(int i = 0; i < array.length; i++) {
				if(value == array[i]) {
					count++;
				}
			}
			return count;
		};
		
		return countEqual;
	}
	


}
