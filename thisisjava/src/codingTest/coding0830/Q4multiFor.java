package codingTest.coding0830;

import java.util.Scanner;

public class Q4multiFor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		String[] strNum = sc.nextLine().split(" ");
		int[] scores = new int[N];
		String[][] blocks = new String[2][N];
//		blocks[0] = sc.nextLine().split("");
//		blocks[1] = sc.nextLine().split("");
		int sum = 0;
		for(int i = 0; i < blocks.length; i++) {
			blocks[i] = sc.nextLine().split("");
			scores[i] = Integer.parseInt(strNum[i]);
			System.out.println(scores[i]);
			for(int j = 0; j < N; j++) {
				
				if( blocks[0][i].equals("O") && blocks[1][i].equals("O") ) {
						sum += scores[i];
				}
			}
//			blocks[1] = sc.nextLine().split("");
		}
		
//		for(int i = 0; i < N; i++) {
//			scores[i] = Integer.parseInt(strNum[i]);
//			if( blocks[0][i].equals("O") && blocks[1][i].equals("O") ) {
//					sum += scores[i];
//			}
//			
//		}
		System.out.println("총 점수");
		System.out.println(sum);
	}

}
