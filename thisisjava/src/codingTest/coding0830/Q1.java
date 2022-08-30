package codingTest.coding0830;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		/*
		 *  시작수와 끝수를 입력 받고 주어진 배수의 합을 출력
		 *  
		 *  [입력]
			시작수: 1
			끝수: 15
			배수: 7
			
			[출력]
			21
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("시작수: ");
		int firstNum = sc.nextInt();
		System.out.print("끝수: ");
		int lastNum = sc.nextInt();
		System.out.print("배수: ");
		int mulNum = sc.nextInt();
		
		int sum = 0;
		
		for(int i = firstNum; i <= lastNum; i++) {
			if(i % mulNum == 0) {
				sum += i;
			}
		}
		
		System.out.println(sum);
		
	}

}
