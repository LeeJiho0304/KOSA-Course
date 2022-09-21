package ch14.sec02;

public class MainThreadExample {

	public static void main(String[] args) {
		System.out.println("시작");
		
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread.getName());
		
		System.out.println("종료");
	}

}
