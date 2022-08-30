package codingTest.coding0830;

import java.util.Scanner;

public class Q4 {

	public static void main(String[] args) {
		/*
		 * 장애물 2개가 없어야 적중 가능
		 */
		
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		String[] scores = sc.nextLine().split(" "); // 숫자 입력 배열
		String[] block1 = sc.nextLine().split("");  // 첫 번째 장애물 저장 배열
		String[] block2 = sc.nextLine().split("");  // 두 번째 자애물 저장 배열 
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			if(block1[i].equals("O") && block2[i].equals("O")) {
				sum += Integer.parseInt(scores[i]);;
			}
		}
		System.out.println("총 점수");
		System.out.println(sum);
	}

}
