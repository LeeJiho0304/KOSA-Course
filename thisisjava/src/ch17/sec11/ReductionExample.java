package ch17.sec11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReductionExample {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("홍길동", 50),
				new Student("김길동", 80),
				new Student("서길동", 90));
		
		//방법1
		int sum1 = list.stream()
					.mapToInt(Student :: getScore)
					.sum();
		
		//방법2
		int sum2 = list.stream()
				.mapToInt(Student :: getScore)
				.reduce(0, (x, y) -> x + y);
		
		System.out.println("sum1: " + sum1);
		System.out.println("sum2: " + sum2);
	}

}
