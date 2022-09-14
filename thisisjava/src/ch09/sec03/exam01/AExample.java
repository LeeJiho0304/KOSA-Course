package ch09.sec03.exam01;

public class AExample {

	public static void main(String[] args) {
		A.B b = new A.B();
		//A 안에 static 으로 Nested 된 B 클래스
		b.methodB();
	}

}
