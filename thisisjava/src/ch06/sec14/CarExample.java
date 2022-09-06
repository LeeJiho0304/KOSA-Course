package ch06.sec14;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.setSpeed(-50);
		System.out.println("현재 속도: " + myCar.getSpeed());
		
		myCar.setSpeed(60);
		System.out.println("현재 속도: " + myCar.getSpeed());
		
		if(!myCar.isStop()) { //현재 차가 움직이고 있다면 멈춰라
			myCar.setStop(true);
		}
		System.out.println("현재 속도: " + myCar.getSpeed());
	}

}
