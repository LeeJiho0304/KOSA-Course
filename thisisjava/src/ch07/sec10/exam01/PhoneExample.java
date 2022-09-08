package ch07.sec10.exam01;

public class PhoneExample {

	public static void main(String[] args) {
		//Phone은 abstract class 이므로 객체 생성 불가능
		//Phone phone = new Phone("홍길동");
		SmartPhone smartPhone = new SmartPhone("홍길동");
		
		smartPhone.turnOn();
		smartPhone.internetSearch();
		smartPhone.turnOff();
	}

}
