package ch17.sec04.exam02;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		String[] strArray = {"홍길동", "김길동", "서길동"};
		Stream<String> stream = Arrays.stream(strArray);
		stream.forEach(s -> System.out.print(s + ", "));
		System.out.println();
		
		int[] intArray = {1, 2, 3, 4, 5};
		IntStream intStream = Arrays.stream(intArray);
		intStream.forEach(i -> System.out.print(i + ", "));
 	}

}
