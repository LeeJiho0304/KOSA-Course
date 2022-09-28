package ch17.sec07.exam01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingExample {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("홍길동", 60));
		list.add(new Student("서길동", 20));
		list.add(new Student("김길동", 90));
		list.add(new Student("남길동", 70));
		
		list.stream()
			.sorted()
			.forEach(data -> System.out.println(data.getScore()));
		
		System.out.println();
		
		list.stream()
		.sorted(Comparator.reverseOrder())
		.forEach(data -> System.out.println(data.getScore()));
	}

}
