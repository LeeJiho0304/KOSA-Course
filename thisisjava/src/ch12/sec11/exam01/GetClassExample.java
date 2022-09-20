package ch12.sec11.exam01;

public class GetClassExample {

	public static void main(String[] args) throws Exception {
		//방법1
		//Class clazz = Car.class;
		
		//방법2
		//Class clazz = Class.forName("ch12.sec11.exam01.Car");  //NotFoundClassException 발생
		
		//방법3
		Car car = new Car();
		Class clazz = car.getClass();
		
		System.out.println("패키지: " + clazz.getPackage().getName());
		System.out.println("클래스 간단 이름: " + clazz.getSimpleName());
		System.out.println("클래스 전체 이름: " + clazz.getName());
	}

}
