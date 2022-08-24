package ch04.sec05;

import java.util.Scanner;

public class KeyControlExample {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int speed = 0;
		
		while(run) {
			System.out.println("-------------------------");
			System.out.println("1. 증속 | 2. 감속 | 3. 중지");
			System.out.println("-------------------------");
			System.out.print("선택: ");
			
			String strNum = sc.nextLine();
			
			if(strNum.equals("1")) {
				speed++;
				System.out.println("현재 속도 = " + speed);
			} else if(strNum.equals("2")) {
				speed--;
				System.out.println("현재 속도 = " + speed);
			} else if(strNum.equals("3")){
				run = false;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
			
			// swtich문
			/*
			switch(strNum)	{
				case "1" -> {
					speed++;
					System.out.println("현재 속도 = " + speed);
				}
				case "2" -> {
					speed--;
					System.out.println("현재 속도 = " + speed);
				}
				case "3" -> run = false;
				default -> System.out.println("잘못 입력하셨습니다.");;
			}
			*/
		}
		
		System.out.println("프로그램 종료");
	}

}
