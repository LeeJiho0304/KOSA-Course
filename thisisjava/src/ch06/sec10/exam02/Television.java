package ch06.sec10.exam02;

public class Television {
	static String company = "MyCompany";
	static String model = "LCD";
	static String info;
	int size;
	
	static {  // 정적블록은 초기화되지않은 정적필드를 초기화함.
		System.out.println("1");
		info = "정보: " + company;
		info += "-" + model;
	}
	
	static {
		System.out.println("2");
	}
}
