package ch04.practice;

import java.util.Scanner;

public class Practice07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean select = true;
		int total = 0;
		
		while(select) {
			System.out.println("----------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("----------------------------------");
			System.out.print("선택> ");
			
			String strNum = sc.nextLine();
			
			if(strNum.equals("1")) {
				System.out.print("예금액> ");
				int money = Integer.parseInt(sc.nextLine());
				total += money;
			} else if(strNum.equals("2")) {
				System.out.print("출금액> ");
				int money = Integer.parseInt(sc.nextLine());
				total -= money;
			} else if(strNum.equals("3")) {
				System.out.println("잔고> "+ total);
			} else if(strNum.equals("4")) {
				select = false;
			} else {
				System.out.println("잘못 입력했습니다.");
			}
			
			System.out.println();
			
			/* switch문
			switch(strNum) {
				case "1":
					System.out.print("예금액> ");
					int money = Integer.parseInt(sc.nextLine());
					total += money;
					break;
				case "2":
					System.out.print("출금액> ");
					int money = Integer.parseInt(sc.nextLine());
					total -= money;
					break;
				case "3":
					System.out.println("잔고> "+ total);
					break;
				case "4":
					select = false;
					break;

			}*/
			
		}
		System.out.println("프로그램 종료");
	}

}
