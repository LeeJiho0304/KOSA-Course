package ch16.practice.q4;

public class Example {

	public static void main(String[] args) {
		//실행 결과
		//작업 스레드가 실행됩니다. * 3
		Thread thread = new Thread(() -> {
			for(int i = 0; i < 3; i++) {
				System.out.println("작업 스레드가 실행됩니다.");
			}
		});
		thread.start();
		
	}

}
