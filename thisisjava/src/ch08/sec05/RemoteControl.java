package ch08.sec05;

public interface RemoteControl {
	//상수 필드
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	//추상 메소드 //사용할 수 있는 기능 (3가지)
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	int getVolume();
	
	//default 인스턴스 메소드
	//객체가 있어야만 실행할 수 있기때문에 추상메소드 호출 가능
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다.");
			setVolume(MIN_VOLUME);
		} else {
			System.out.println("무음 해제합니다.");
		}
	}
}
