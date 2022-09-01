package ch06.sec06.exam02;

public class CarExample {

	public static void main(String[] args) {
		// Car 객체 생성
		Car myCar = new Car(); // new 생성자로 Car 객체를 생성하고 객체의 번지수를 리턴해 Car 타입의 myCar 변수에 저장
		
		// Car 객체의 필드값 읽기
		System.out.println("제작회사: " + myCar.company);  // Car객체의 정보를 가지고있는 myCar변수를 통해 필드값에 접근
		System.out.println("모델명: " + myCar.model);
		System.out.println("색깔: " + myCar.color);
		System.out.println("최고속도: " + myCar.maxSeed);
		System.out.println("현재속도: " + myCar.speed);
		
		// Car 객체의 필드값 변경
		myCar.speed = 60;
		System.out.println("수정된 속도: " + myCar.speed);
	}

}
