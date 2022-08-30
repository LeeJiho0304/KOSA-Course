package codingTest.coding0830;

import java.util.Scanner;

public class Q3String {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split("");

//		System.out.println(Integer.parseInt(str[0]));
		String[] alphabet = "abcdefghijklmnopqrstuvWxyz".split("");
		
		

//		for(int i = 0; i < str.length; i ++) {
//			char strNum = str.charAt(i); // 문자열 str 에 저정된 값을 char타입으로 변환
//			if( strNum + 4 > 'z') {
//				password = (char) (strNum + 4 - 26);  // 연산을 하면 int 타입으로 자동 타입 변환이 되기때문에 char로 casting 해줘야함
//													  // 알파벳 개수 26개 이기때문에 -26해서 'a'로
//			} else {
//				password = (char) (strNum + 4);
//			}
//			System.out.print(password);
//		}
	}

}
