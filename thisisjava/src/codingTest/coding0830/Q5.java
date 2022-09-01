package codingTest.coding0830;

import java.util.Scanner;

public class Q5 {

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

		String[] knownWord = new String[N];
		String[] teacherWord = sc.nextLine().split(" ");
		
		int cnt = 0;   // 기억하고 있는 단어의 갯수
		int total = 0;  // 총 걸린 시간
		int strLength = 0;  // 문자열 길이 합
		boolean check = false;  // 알고 있는 지 확인 ( 알고있으면 true, 모르면 false )
		int index = 0;
		
		
		
		for(int i = 0; i < W; i ++) {
			
			for(int j = 0; j < cnt; j++) { // 알고 있는지 확인
				if(knownWord[j].equals(teacherWord[i]))	{
					check = true;
					index = j;
					break;
				}
			}
			
			if(!check) { // 단어를 모르는 경우 ( 용량이 다 안찬경우, 용량이 다 찬경우)
				total += 3;
				if(cnt < N) {  // 용량이 다 안찬 경우
					knownWord[cnt++] = teacherWord[i];
				} else { // 용량이 다 찬 경우
					for(int j = 0; j < N; j++) {
						strLength += knownWord[j].length();
					}
					int avg = strLength / N;
					for(int j = 0; j < N; j++) {
						if( (knownWord[j].length() <= avg)) {
							knownWord[j] = teacherWord[i];
							break;
						}
					}
				}
				
			} else { // 단어를 알고 있는 경우
				total += 1;
				// swap
				/*String temp = knownWord[N-1];
				knownWord[N-1] = knownWord[0];
				for (int j = N-2; j > 0; j--) {
					knownWord[j-1] = knownWord[j];
				}
				knownWord[0] = temp;*/
				for (int j = index; j < cnt - 1; j++) {
					knownWord[j] = knownWord[j + 1];
				}
				knownWord[cnt - 1] = teacherWord[i];

				
			}
			for (int k = 0; k < N; k++) {
				System.out.print(knownWord[k] + " ");
			}
			System.out.println("- " + total);
		}

		System.out.println(total);
	}

}
