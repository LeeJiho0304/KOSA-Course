package ch05.team;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[][] jang = {
				//num = 1
				{"철수", "소고기"},//i = 0  count = 0
				{"철수", "김밥"},//i = 1 count = 0
				{"영희", "김치"},//i = 2 count = 1
				{"철수", "바나나"},//i = 3 count = 1;
				{"철수", "새우깡"},//i = 4 count = 1
				{"영희", "오징어"},//i = 5 count = 1, num = 1 => 그래서 지우려는 진짜번호가 5가 check에 저장된다 그후에 count 가 증가된다
				{"영희", "맛밤"}//i = 6 count = 2;
				
		};
		
		for (int i = 0; i < jang.length; i++) {
			System.out.println(jang[i][0] + " " + jang[i][1]);
		}
		
		
		System.out.println("삭제할 이름을 입력하세요");
		String name = scanner.next();
		
		System.out.println("삭제할 번호를 입력하세요");
		int num = scanner.nextInt();
		
		int check = -1;
		
		int count = 0;
		for (int i = 0; i < jang.length; i++) {
			if (name.equals(jang[i][0])) {
				if (count == num) {
					check = i;
				}
				count += 1;
			}
		}
		
		System.out.println(check);
		
		String[][] temp = jang;
		
		jang = new String[temp.length - 1][2];
		
		int j = 0;
		for (int i = 0; i < temp.length; i++) {
			if (i != check) {
				jang[j] = temp[i];
				j += 1;
			}
		}
		
		for (int i = 0; i < jang.length; i++) {
			System.out.println(jang[i][0] + " : " + jang[i][1]);
		}
	
	}

}
