package ch07.sec04.exam01;

public class Computer extends Calculator {
	//메소드 오버라이딩
	//annotation 을 사용하면 정확히 오버라이딩이 되었는지 체크
	@Override
	public double areaCricle(double r) {
		System.out.println("Computer 객체의 areaCircle() 실행");
		return Math.PI * r * r;
	}
	
}
