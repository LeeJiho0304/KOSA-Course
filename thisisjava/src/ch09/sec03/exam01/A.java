package ch09.sec03.exam01;

public class A {
	//Nested Class
	//A 객체와는 상관없지만 밀접한 관계가 있는 경우는 static
	static class B {
		void methodB() {
			System.out.println("methodB() 실행");
		}
	}
	
	//field
	B field1 = new B(); //class B가 static이 아니여도 필드이므로 사용가능
	static B field2 = new B();  //정적 멤버를 선언하려면 객체가 없어도 사용가능한 클래스 타입을 사용해야함(static class B)
	
	//Constructor
	A() {
		B field1 = new B();
	}
	
	//Method
	void method1() {
		B field1 = new B();
	}
	
	static void method2() {
		B field1 = new B();
	}
}
