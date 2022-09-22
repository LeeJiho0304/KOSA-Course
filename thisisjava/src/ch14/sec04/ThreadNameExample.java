package ch14.sec04;

public class ThreadNameExample {

	public static void main(String[] args) {
		
		Thread mainTread = Thread.currentThread();
		System.out.println(mainTread.getName() + " 실행");
		
		for(int i = 0; i < 3; i++) {
			Thread thread = new Thread() {
				@Override
				public void run() {
					System.out.println(getName() + " 실행");
				}
			};
			thread.start();
		}
		
		Thread chatThread = new Thread() {
			@Override
			public void run() {
				System.out.println(getName() + " 실행");
			}
		};
		
		chatThread.setName("chat-thread");
		chatThread.start();
	}

}
