package codingTest.coding0830;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		/*
		 *  입력한 값 4번째 뒤 알파벳으로 변환
		 *  abcdefghijklmnopqrstuvwxyz (26개)
		 *  'a' = 97
		 *  'z' = 122
		 */
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		char password; // 4번째 뒤 문자로 변환한 비밀번호를 저장할 변수

		for(int i = 0; i < str.length(); i++) {
			char strNum = str.charAt(i); // 문자열에서 특정 위치의 문자를 얻는 charAt()메소드 사용
			if( strNum + 4 > 'z') {
				password = (char) (strNum + 4 - 26);  // 연산을 하면 int 타입으로 자동 타입 변환이 되기때문에 char로 casting 해줘야함
													  // 알파벳 개수 26개 이기때문에 -26해서 'a'로
			} else {
				password = (char) (strNum + 4);
			}
			System.out.print(password);
		}
	}

}
