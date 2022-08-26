package ch05.practice;

import java.util.Scanner;

public class Practice09 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		
		while(run) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("--------------------------------------------------------------");
			System.out.print("선택> ");
			
			int selectNum = scanner.nextInt();
			
			//switch문
			switch(selectNum) {
				case 1:
					System.out.print("학생수> ");
					studentNum = scanner.nextInt();
					//학생 수 길이만큼의 배열 생성
					scores = new int[studentNum];
					break;
				case 2:
					for(int i=0; i<scores.length; i++) {
						System.out.print("scores[" + i + "]> ");
						scores[i] = scanner.nextInt();
					}
					break;
				case 3:
					for(int i=0; i<scores.length; i++) {
						System.out.println("scores[" + i + "]: " + scores[i]);
					}
					break;
				case 4:
					int max = 0;
					int sum = 0;
					
					for(int i=0; i<scores.length; i++) {
						if( max< scores[i] ) {
							max = scores[i];
						}
						sum += scores[i];
					}
					double avg = (double) sum / scores.length;
					System.out.println("최고 점수: " + max);
					System.out.println("평균 점수: " + avg);
					break;
				case 5:
					run = false;
			}
//			if(selectNum == 1) {
//				System.out.print("학생수> ");
//				studentNum = scanner.nextInt();
//				//학생 수 길이만큼의 배열 생성
//				scores = new int[studentNum];
//			} else if(selectNum == 2) {
//				for(int i=0; i<scores.length; i++) {
//					System.out.print("scores[" + i + "]> ");
//					scores[i] = scanner.nextInt();
//				}
//
//			} else if(selectNum == 3) {
//				for(int i=0; i<scores.length; i++) {
//					System.out.println("scores[" + i + "]: " + scores[i]);
//				}
//			} else if(selectNum == 4) {
//				int max = 0;
//				int sum = 0;
//				
//				for(int i=0; i<scores.length; i++) {
//					if( max< scores[i] ) {
//						max = scores[i];
//					}
//					sum += scores[i];
//				}
//				double avg = (double) sum / scores.length;
//				System.out.println("최고 점수: " + max);
//				System.out.println("평균 점수: " + avg);
//	
//			} else if(selectNum == 5) {
//				run = false;
//			} else	{
//				System.out.println("잘못 입력했습니다.");
//			}
			
			
			
		}	
		
		System.out.println("프로그램 종료");
	}

}
