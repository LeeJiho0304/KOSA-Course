package ch08.sec02;

public class RemoteControlExample {

	public static void main(String[] args) {
		//RemoteControl 인터페이스를 통해서 Television 객체를 사용하겠다. 
		RemoteControl rc = new Television();
		rc.turnOn();
		
		rc = new Audio();
		rc.turnOn();
	}

}
