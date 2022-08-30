package codingTest.coding0829;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		/*
		 * 정수 a,b,c 곱한 값에 0~9 숫자가 각각 몇개
		 */
		
		Scanner sc = new Scanner(System.in); 
	
		String[] strNum = sc.nextLine().split(",");  //String 타입의 배열 strNum을 선언하고 입력값(150,266,427)을 잘라서 저장
		int multi = 1; //곱한 값
		
		for(int i = 0; i < strNum.length; i++) { // 입력값 곱하기
			multi *= Integer.parseInt(strNum[i]);  //strNum은 String타입이기 때문에 Integer.parseInt로 int타입으로 변환
		}
		
		String[] num = String.valueOf(multi).split(""); // 17037300 숫자를 문자열로 변환해서 한글자씩 잘라 저장
		int[] numCount = new int[10];  // index[0~9]로 비교하고 개수를 count해 저장하는 배열
		
		for(int i = 0; i < num.length; i++) { 
			for(int j = 0; j < 10; j++) {
				if(num[i].equals(String.valueOf(j))) { // num은 String타입 배열이라 equals 메소드로 비교. j는 int 타입이라 String.valueOf() 메소드를 사용해 int -> String
					numCount[j]++;  //0~9 숫자가 있으면 증가
				}
			}
		}
		
		for(int n : numCount) {
			System.out.println(n);
		}
	}

}
