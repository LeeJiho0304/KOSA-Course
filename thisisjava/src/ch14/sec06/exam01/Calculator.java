package ch14.sec06.exam01;

public class Calculator {
	//Calculator 은 공유 객체
	//공유 객체 안에 동기화 메소드, 블록을 선언
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	//메소드 동기화
	public synchronized void setMemory1(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch(Exception e) {}
		System.out.println(Thread.currentThread().getName() + ": " + this.memory);
	}
	
	//블록 메소드
	public void setMemory2(int memory) {
		//...
		synchronized (this) {  //잠굴 객체
			this.memory = memory;
			try {
				Thread.sleep(2000);
			} catch(Exception e) {}
			System.out.println(Thread.currentThread().getName() + ": " + this.memory);
		}
		//...
		
	}
}
