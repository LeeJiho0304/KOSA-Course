package ch17.sec09;

import java.util.Arrays;

public class MatchingExample {

	public static void main(String[] args) {
		int[] intArray = {2, 3, 6};
		
		boolean result = Arrays.stream(intArray)
								.allMatch(n -> n % 2 == 0);
		System.out.println("모두 2의 배수인가? " + result);
		
		result = Arrays.stream(intArray)
								.anyMatch(n -> n % 3 == 0);
		System.out.println("하나라도 3의 배수인가? " + result);
		
		result = Arrays.stream(intArray)
								.noneMatch(n -> n % 3 == 0);
		System.out.println("3의 배수가 없는가? " + result);
		
	}

}
