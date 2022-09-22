package ch14.sec05.exam02;

public class JoinExample {

	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		sumThread.start();
		
		try {
			System.out.println(Thread.currentThread().getState());
			sumThread.join();
		} catch (InterruptedException e) {
		}
		
		System.out.println("1~100 합: " + sumThread.getSum());
	}

}
