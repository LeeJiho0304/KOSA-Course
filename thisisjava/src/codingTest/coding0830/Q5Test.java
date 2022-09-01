package codingTest.coding0830;

import java.util.Scanner;

public class Q5Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.next());  // 알고있는 단어 갯수
		int w = Integer.parseInt(sc.next());  // 물어볼 단어 갯수
		sc.nextLine();
		
		String[] word = sc.nextLine().split(" "); // 입력 선생님
		String[] remember = new String[n]; // 내가 기억하는 단어 배열
		int len = 0;  //내가 현재 기억하고 있는 갯수
		int time = 0;  // 걸리는 시간

		for (int i = 0; i < w; i++) {
			// 현재 탐색중인 단어를 내가 알고있는지
			boolean know = false;
			int idx = 0;  // 외우고 있다면 그 단어의 위치
			for (int j = 0; j < len; j++) {
				if (remember[j].equals(word[i])) {
					know = true;
					idx = j;		// 알고있는 단어의 인덱스값
					break;
				}
			}

			if (know) {  // 아는 단어일 때
				time += 1;
				// 알고 있는 단어를 최근으로 갱신
				for (int j = idx; j < len - 1; j++) {  // 중복일때 제외하기 위해 idx 부터 len-1까지
					remember[j] = remember[j + 1];
				}
				remember[len - 1] = word[i];

			} else { // 모르는 단어일 때
				time += 3;
				// 기억 용량이 다 찬 경우
				if (len == n) {
					int sum = 0;
					for (int j = 0; j < len; j++) {
						sum += remember[j].length();
					}
					int avg = sum / len;
					idx = 0;
					for (int j = 0; j < len; j++) {
						if (remember[j].length() <= avg) {
							idx = j;
							break;
						}
					}
					remember[len - 1] = word[i];
				}
				// 여유 있는 경우
				else {
					remember[len++] = word[i];
				}
			}
			for (int k = 0; k < len; k++) {
				System.out.print(remember[k] + " ");
			}
			System.out.println("- " + time);
		}

	}

}
