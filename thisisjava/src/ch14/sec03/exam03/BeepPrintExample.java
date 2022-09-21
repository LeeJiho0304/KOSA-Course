package ch14.sec03.exam03;

import java.awt.Toolkit;

public class BeepPrintExample {

	public static void main(String[] args) {
		Thread thread1 = new Thread() {  //익명 자식 객체
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i = 0; i < 5; i++) {
					toolkit.beep();
					try {
						Thread.sleep(1000);
					} catch(Exception e) {}
				}
			}
		};
		
		thread1.start();
		
		//작업2
		/*
		for(int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(2000);
			} catch(Exception e) {}
		}
		*/
		
		//명시적으로 선언하면 재사용하기 용이
		Thread thread2 = new PrintThread();
		thread2.start();
		
		System.out.println("main thread 종료");
	}
}
