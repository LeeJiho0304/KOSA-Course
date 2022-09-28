package ch17.sec07.exam02;

import java.util.ArrayList;
import java.util.List;

import ch17.sec07.exam01.Student;

public class SortingExample {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("홍길동", 60));
		list.add(new Student("서길동", 20));
		list.add(new Student("김길동", 90));
		list.add(new Student("남길동", 70));
		
		list.stream()
			.sorted((s1, s2) -> Integer.compare(s1.getScore(), s2.getScore()))
			.forEach(data -> System.out.println(data.getName() + ": " + data.getScore() ));
		System.out.println();
		
		list.stream()
			.sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
			.forEach(data -> System.out.println(data.getName() + ": " + data.getScore() ));
		
		System.out.println();
		
		list.stream()
		.sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()))
		.forEach(data -> System.out.println(data.getName() + ": " + data.getScore() ));
		
	}

}
