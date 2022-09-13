package ch08.sec06;

public class Television implements RemoteControl {
	//필드
	private int volume;

	@Override
	public void turnOn() { //인터페이스에서 선언된 turnOn() 추상 메소드 재정의
		System.out.println("TV를 켭니다.");
	}
	
	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}
	
	//무결성을 유지하기위해 Setter로 접근
	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 TV 볼륨: " + this.volume);
	}
	
	@Override
	public int getVolume() {
		return this.volume;
	}
}
