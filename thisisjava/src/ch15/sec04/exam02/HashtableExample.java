package ch15.sec04.exam02;

import java.util.Hashtable;
import java.util.Map;

public class HashtableExample {

	public static void main(String[] args) {
		//Hashtable 컬렉션 생성
		Map<String,Integer> map = new Hashtable<>();
		//Map<String,Integer> map = new HashMap<>();
		//HashMap으로 할 경우 두 스레드가 동시에 put()메소드를 호출할 수 있기 때문에 경합이 발생하고 결국 하나만 저장.
		//2000개가 출력되지 않음.
		
		//작업스레드 객체 생성
		Thread threadA = new Thread() {
			@Override
			public void run() {
				for(int i = 1; i <= 1000; i++) {
					map.put(String.valueOf(i), i);
				}
			}
		};
		
		//작업스레드 객체 생성
		Thread threadB = new Thread() {
			@Override
			public void run() {
				for(int i = 1001; i <= 2000; i++) {
					map.put(String.valueOf(i), i);
				}
			}
		};
		
		//작업스레드 실행
		threadA.start();
		threadB.start();
		
		//작업 스레드들이 모두 종료될 때까지 메인 스레드를 기다리게 함
		
		try {
			threadA.join();
			threadB.join();
		} catch (InterruptedException e) {
		}
		
		//저장된 총 엔트리 수 얻기
		System.out.println("총 Entry 수: " + map.size());
	}

}
