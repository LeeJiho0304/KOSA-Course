package ch09.sec02.exam02;

public class AExample {

	public static void main(String[] args) {
		//A.B b = new A.B(); 불가능
		A a = new A();
		
		a.useB();
	}

}
