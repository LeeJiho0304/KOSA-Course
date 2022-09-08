package ch07.sec11;

public sealed class Person permits Employee, Manager {
	// permits한 class는 받드시 상속을 받아야한다.
	public String name;
	
	public void work() {
		System.out.println("하는 일이 결정되지 않았습니다.");
	}
}
