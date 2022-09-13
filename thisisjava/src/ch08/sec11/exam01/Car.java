package ch08.sec11.exam01;

public class Car {
	//필드
	Tire tire1 = new HankookTire();
	Tire tire2 = new HankookTire();
	
	//HankookTire tire1;
	//KumhoTire tire2; 
	//사용 가능하지만 tire1에는 HankookTire만 대입가능, tire2에는 KumhoTire만 대입가능
	
	void run() {
		tire1.roll();
		tire2.roll();
	}
}
