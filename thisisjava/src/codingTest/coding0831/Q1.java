package codingTest.coding0831;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String  str = sc.nextLine();
		String[] str1 = str.split("");
		int floor = 0; // 현재 위치한 층
		int kcal = 0;  // 칼로리
		int slope = 1; // 경사
		boolean check = false;  // 경사 구간인지 확인

		for(int i = 0; i < str1.length; i++) {
			if(str1[i].equals("(")) {
				floor++;
				kcal += (floor*slope);
			} else if(str1[i].equals(")")) {
				kcal += floor*slope;
				floor--;
			} else if(str1[i].equals("#")) {
				if(check == false) {
					slope = 2;
					check = true;
				} else {
					slope = 1;
					check = false;
				}
			}
		}
		
		System.out.println(kcal);
	}

}
