package ch14.sec09.exam03;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableSubmitExample {

	public static void main(String[] args) {
		//스레드 풀 생성
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		for(int i = 1; i <= 100; i++) {
			final int idx = i;
			Future<Integer> future = executorService.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					int sum = 0;
					for(int i = 1; i <= idx; i++) {
						sum += i;
					}
					Thread thread = Thread.currentThread();
					System.out.println("[" + thread.getName() + "] 1~" + idx + " 합 계산");
					return sum;
				}
			});
			
			try {
				int result = future.get();
				System.out.println("\t 리턴값: " + result);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			
		}
		
		
		executorService.shutdown();
	}

}
