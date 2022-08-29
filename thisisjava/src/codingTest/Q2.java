package codingTest;

import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		/*
		 * 7개의 자연수 중 홀수 선택 홀수 총합, 최솟값
		 * 홀수가 없을 경우 -1출력
		 */
		
		Scanner sc = new Scanner(System.in); 
		
		String[] strNum = sc.nextLine().split(",");
		int[] oddArray = new int[strNum.length]; // 홀수 값들을 저장할 배열 생성
		
		int cnt = 0; // 홀수의 개수
		for (int i = 0; i < strNum.length; i++) {		
			oddArray[i] = Integer.parseInt(strNum[i]);
			if(oddArray[i] % 2 != 0) {
				oddArray[cnt] = oddArray[i];
				cnt++;
			}
		}
		
		int sum = 0;
		int min = oddArray[0];
		for (int i = 0; i < cnt; i++) {
			sum += oddArray[i];
			if(min > oddArray[i]) {  // 최솟값 구하기
				min = oddArray[i]; 
			}
		}
		
		if(oddArray[0] == 0)	{ // 홀수 값 없으면 -1 출력
			System.out.println("-1");
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
		
	}

}
