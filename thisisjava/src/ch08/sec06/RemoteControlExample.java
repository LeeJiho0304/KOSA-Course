package ch08.sec06;

public class RemoteControlExample {

	public static void main(String[] args) {
		// 인터페이스 변수 선언
		RemoteControl rc;

		// Television 객체를 생성하고 인터페이스 변수에 대입
		rc = new Television();
		rc.turnOn();
		rc.setVolume(5);

		rc.setMute(true); // rc에 객체가 대입되어있어야만 실행가능
		rc.setMute(false);
		
		System.out.println("현재 볼륨: " + rc.getVolume());
		
		rc = new Audio();
		rc.turnOn();
		rc.setVolume(7);

		rc.setMute(true); // rc에 객체가 대입되어있어야만 실행가능
		rc.setMute(false);
		
		System.out.println("현재 볼륨: " + rc.getVolume());
		
		RemoteControl.changeBattery();
	}

}
