package ch08.sec02;

public interface RemoteControl {
	//추상 메소드
	//abstract 붙여도 상관없다.
	//인터페이스 추상메소드 default 는 public
	public void turnOn(); //RemoteControl 인터페이스에서 turnOn()이라는 기능을 사용할 수 있다. 
}
