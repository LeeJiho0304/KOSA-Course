package ch06.sec13.exam03.package2;

import ch06.sec13.exam03.package1.A;

public class C {
	public C() {
		A a = new A();
		
		a.field1 = 1;
		//a.field2 = 1;  // default 필드는 외부에서 접근 불가(같은 패키지에서만 가능)
		//a.field3 = 1;  // private 필드는 외부에서 접근 불가
		
		a.method1();
		//a.method2();  // default 메소드는 외부에서 접근 불가(같은 패키지에서만 가능)
		//a.method3();  // private 메소드는 외부에서 접근 불가

	}
}
