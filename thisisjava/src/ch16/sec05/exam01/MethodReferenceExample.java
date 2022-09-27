package ch16.sec05.exam01;

public class MethodReferenceExample {

	public static void main(String[] args) {
		
		Person person = new Person();
		
		//정적 메소드 참조
		person.action((x, y) -> Computer.staticMethod(x, y));
		person.action(Computer :: staticMethod);
		
		//인스턴스 메소드 참조
		person.action((x, y) -> new Computer().instancMethod(x, y));
		person.action(new Computer() :: instancMethod);
		
	}

}
