package ch07.sec07.exam02;

public class ChildExample {

	public static void main(String[] args) {
		Child child = new Child();
		
		Parent parent = child;
		
		parent.method1();
		parent.method2();
		//parent.method3();  //호출 불가능
		//Parent 타입의 변수로 선언했기때문에 Parent 타입에 있는 것만 사용 가능
	}

}
