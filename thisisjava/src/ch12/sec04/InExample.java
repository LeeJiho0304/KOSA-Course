package ch12.sec04;

import java.io.IOException;

public class InExample {

	public static void main(String[] args) throws IOException {
		int speed = 0;
		int keyCode = 0;
		
		while(true) {
			if(keyCode != 13 && keyCode != 10) {  //엔터(13, 10)는 제외
				if(keyCode == 49) {  //숫자 1 일때
					speed++;
				} else if(keyCode == 50) {  //숫자 2 일때
					speed--;
				} else if(keyCode == 51) {   //숫자 3 일때
					break;
				}
				
				System.out.println("-------------------------");
				System.out.println("1. 증속 | 2. 감속 | 3. 중지");
				System.out.println("-------------------------");
				System.out.println("현재 속도=" + speed);
				System.out.print("선택: ");
			}
			//키를 하나씩 읽음
			keyCode = System.in.read();
		}
		System.out.println("프로그램 종료");
	}

}
