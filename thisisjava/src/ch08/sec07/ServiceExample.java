package ch08.sec07;

public class ServiceExample {

	public static void main(String[] args) {
		//Service 인터페이스를 통해서 ServiceImpl 객체를 사용하겠다는 의미
		//Service가 인터페이스 ServiceImpl 이 구현 클래스
		Service service = new ServiceImpl();
		
		service.defaultMethod1();
		System.out.println();
		service.defaultMethod2();
		System.out.println();
		
		Service.staticMethod1();
		System.out.println();
		Service.staticMethod2();
		System.out.println();
	}

}
