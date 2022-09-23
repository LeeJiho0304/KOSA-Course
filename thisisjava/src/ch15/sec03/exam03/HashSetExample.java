package ch15.sec03.exam03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("Java");
		set.add("JSP");
		set.add("Spring");
		set.add("JDBC");
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println(element);
			
			if(element.equals("JSP")) {
				iterator.remove();
			}
		}
		System.out.println();
		
		set.remove("JDBC");
		
		for(String element : set) {
			System.out.println(element);
		}
		System.out.println();
		
		for(String element : set) {
			
			if(element.equals("Java")) {
				set.remove(element);
			}
			System.out.println(element);
		}
	}

}
