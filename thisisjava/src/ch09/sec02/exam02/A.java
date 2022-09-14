package ch09.sec02.exam02;

public class A {
	//밀접성이 높은 클래스끼리는 중첩 클래스로 선언
	//A가 없는데 B가 있을 수 없는 경우(A 객체와 밀접한 관계일 경우)
	class B {
		int field = 1;
		
		//Java 17부터 허용
		static int field2 = 2;
		
		B() {
			System.out.println("B-생성자 실행");
		}
		
		void method1() {
			System.out.println("B-method1 실행");
		}
		
		static void method2() {
			System.out.println("B-method2 실행");
		}
	}
	
	void useB() {
		B b = new B();
		System.out.println(b.field);
		b.method1();
		
		System.out.println(B.field2);
		B.method2();
	}
}
