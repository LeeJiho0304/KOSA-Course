package ch07.sec05.exam02;

public class SportsCar extends Car {

	@Override
	public void speedUp() {
		speed += 10;
	}
	
	/* 부모 클래스에서 finaal 로 선언했기때문에 오버라이딩을 할 수 없음
	@Override
	public void stop() {
		System.out.println("스포트카를 멈춤");
		speed = 0;
	}
	*/
}
