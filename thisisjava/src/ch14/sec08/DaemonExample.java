package ch14.sec08;

public class DaemonExample {

	public static void main(String[] args) {
		AutoSaveThread thread = new AutoSaveThread();
		thread.setDaemon(true);
		thread.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		
		thread.interrupt();
		System.out.println("main 스레드 종료");
	}

}
