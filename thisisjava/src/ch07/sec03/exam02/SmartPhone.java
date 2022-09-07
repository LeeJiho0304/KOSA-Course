package ch07.sec03.exam02;

public class SmartPhone extends Phone {
	//자식 생성자 선언
	public SmartPhone(String model, String color) {
		super(model, color); // 부모의 생성자에 기본생성자가 없다면 명시적으로 super을 작성해줘야함
		System.out.println("SmartPhone(String model, String color) 생성자 실행됨");
	}
}
