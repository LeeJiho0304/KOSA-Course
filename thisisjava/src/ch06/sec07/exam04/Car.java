package ch06.sec07.exam04;

public class Car {
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	Car() {
		System.out.println("1");
	}
	
	Car(String model) {
		this.model = model;
		System.out.println("2");
	}
	
	Car(String model, String color) {
		this.model = model;
		this.color = color;
		System.out.println("3");
	}
	
	Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
		System.out.println("4");
	}
}
