package ch06.sec13.exam02.package2;

import ch06.sec13.exam02.package1.A;

public class C {
	// 필드 선언
	A a1 = new A(true);
	//A a2 = new A(1);  // default 생성자는 같은 패키지에서만 접근가능
	//A a3 = new A("문자열");  // private 생성자는 클래스 내부에서만 접근가능
}
