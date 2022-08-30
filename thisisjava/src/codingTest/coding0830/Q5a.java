package codingTest.coding0830;

import java.util.Scanner;

public class Q5a {

	public static void main(String[] args) {
		/*
		 * N개 단어 암기
		 * 알고 있는거면 1초
		 * 모르면 3초
		 * 빈자리 있을 시 새로 저장
		 * 빈자리 없으면 가장 오래된 단어 삭제하고 새로운 단어 암기
		 * 	- 삭제 시 단어들의 평균 길이보다 길면 그 다음 오래된 단어 삭제
		 * 존재하는 단어 들으면 새로 저장(암기 시점 최신)
		 */
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(sc.next());  // 알고있는 단어 갯수
		int W = Integer.parseInt(sc.next());  // 물어볼 단어 갯수
		sc.nextLine();
//		System.out.println("N: " + N + ", W: " + W);
		String[] knownWord = new String[N];
		String[] teacher = sc.nextLine().split(" ");
		
		int cnt = 0;   // 갯수
		int total = 0;  // 총 걸린 시간
		int strLength = 0;
		boolean check = false;  // 알고 있는 지 확인
		
		
		
//		//초기값 저장
//		for(int i = 0; i < N; i++) {
//			if(knownWord[i] == null) {
//				System.out.println("null 일때 초기값");
//				total += 3;
//				knownWord[i] = teacher[i];
//				System.out.println(knownWord[i]);
//				strLength += knownWord[i].length();
//				cnt++;
//			}
//		}
//		for(int i = 0; i < W; i++) {
//			for(int j = 0; j < N; j++) {
//				if(knownWord[j] == null) {
//					System.out.println("null 일때 초기값");
//					total += 3;
//					knownWord[j] = teacher[i];
//					System.out.println(knownWord[j]);
//					strLength += knownWord[j].length();
//				}
//			}
//		}

		for(int i = 0; i < N; i++) {
			if(knownWord[i] == null) {
				total += 3;
				knownWord[i] = teacher[i];
				cnt++;
			}
			if(knownWord[i] != null) {
				break;
			}
		}
		System.out.println("total " + total);
		for(int i = cnt; i < W; i++) {
			strLength = 0;
			for(int j = 0; j < N; j++) {
//				System.out.println("known[" + j + "]: " + knownWord[j]);
				strLength += knownWord[cnt].length();
				if(!knownWord[j].equals(teacher[i])) {
//					total += 3;
//					System.out.println("아는 단어 없을때  total : " + total);
//					System.out.println("known[" + j + "]: " + knownWord[j]);
//					System.out.println("teacher[" + i + "]: " + teacher[i]);
//					for(int k = 0; k < N; k++) {
//						strLength += knownWord[k].length();
//					}
					System.out.println("길이 총합 : "+ strLength);
					int avg = strLength / N;
					if((i > N) ) {
						for(int k = 0; k < N; k++) {
							if( (knownWord[k].length() <= avg)) {
								total += 3;
//								System.out.println("i: " + i + ", length: " + knownWord[k].length() + ", avg: " + avg);
								knownWord[k] = teacher[i];
								break;
							}
						}
						
					}
					
				} else if(knownWord[j].equals(teacher[i])) {
//					System.out.println("아는 단어일때    total: " + total);
//					System.out.println("known[" + j + "]: " + knownWord[j]);
//					System.out.println("teacher[" + i + "]: " + teacher[i]);
					total += 1;
					knownWord[j] = teacher[i];
					break;
				}
			}
			
			for (int k = 0; k < N; k++) {
				System.out.print(knownWord[k] + " ");
			}
			System.out.println("- " + total);

		}
		
		System.out.println(total);
	}

}
