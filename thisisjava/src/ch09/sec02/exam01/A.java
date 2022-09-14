package ch09.sec02.exam01;

public class A {
	//Field
	int field;
	B field2;
	
	//Constructor
	A() {
		B b = new B();
		b.methodB();
	}
	
	//Method
	void methodA() {  //인스턴스 메소드
		B b = new B();
		b.methodB();
	}
	
	//Nested Class
	public class B {
		//Filed
		//Constructor
		//Method
		public void methodB() {
			System.out.println("methodB() 실행");
		}
	}
	
	B filed = new B();
	
}
