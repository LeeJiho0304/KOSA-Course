package ch08.sec10.exam02;

public class CastingExample {

	public static void main(String[] args) {
		Vehicle vehicle = new Bus();
		vehicle.run();
		//vehicle.checkFare();
		
		//강제 타입 변환 후 호출
		Bus bus = (Bus) vehicle;
		bus.run();
		bus.checkFare();
	}

}
