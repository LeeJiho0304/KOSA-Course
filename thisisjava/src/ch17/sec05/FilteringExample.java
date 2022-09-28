package ch17.sec05;

import java.util.ArrayList;
import java.util.List;

public class FilteringExample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("홍길동");
		list.add("김길동");
		list.add("홍길동");
		list.add("서길동");
		list.add("김자바");
		list.add("김자바");
		
		list.stream()
			.distinct()
			.forEach(name -> System.out.println(name));
		
		System.out.println();
		
		list.stream()
			.filter(name -> name.startsWith("김"))
			.forEach(name -> System.out.println(name));
		
		System.out.println();
		
		list.stream()
			.distinct()
			.filter(name -> name.startsWith("김"))
			.forEach(name -> System.out.println(name));
	}

}
