package ch06.sec07.exam05;

public class Car {
	// 필드 선언
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	Car(String model) {
		//System.out.println("1"); this()는 생성자의 첫 줄에 작성되어야 한다.
		this(model, "은색", 250);
		System.out.println("1");
	}
	
	Car(String model, String color) {
		//System.out.println("2");
		this(model, color, 250);
		System.out.println("2");
	}
	
	Car(String model, String color, int maxSpeed) {
		//System.out.println("3");
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
		System.out.println("3");
	}
}
