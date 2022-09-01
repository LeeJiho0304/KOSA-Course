package ch06.sec06.exam01;

public class CarExample {

	public static void main(String[] args) {
		// Car 객체 생성
		Car myCar = new Car();  // Car 객체를 생성하고 그 객체가 저장된 번지를 myCar 변수에 리턴해 저장
		
		// Car 객체의 필드값 읽기
		System.out.println("모델명: " + myCar.model); // Car객체가 가지고있는 model 객체
		System.out.println("시동여부: " + myCar.start);
		System.out.println("현재속도: " + myCar.speed);
	}

}
