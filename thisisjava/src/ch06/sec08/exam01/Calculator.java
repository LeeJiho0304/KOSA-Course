package ch06.sec08.exam01;

import java.util.Scanner;

public class Calculator {
	Calculator() {
	}
	
	Calculator(int x, int y) {
		plus(x, y);//  호출만 되고 저장안됌
	}
	
	// 리턴값이 없는 메소드 선언
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	
	// 리턴값이 없는 메소드 선언
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	
	// 호출 시 두 정수 값을 전달받고, 호출한 곳으로 결과값 int를 리턴하는 메소드 선언
	int plus(int x, int y) {
		int result = x + y;
		return result;
	}
	
	// 호출 시 두 정수 값을 전달받고, 호출한 곳으로 결과값 double을 리턴하는 메소드 선언
	double divide(int x, int y) {
		double result = (double) x / y;
		return result;
	}
	
	// 두 수를 제공 받아서 첫째수의 둘째수제곱을 리턴값으로 하는 메소드 선언
	long power(int x, int y) {
		long result = 1;
		for(int i = 0; i < y; i++) {
			result *= x;
		}
		
		return result;
	}
	
	// 한 수를 제공받고 n!를 값을 리턴하는 메소드를 선언
	long factorial(int n) {
		long result = 1;
		for(int i = n; i > 0; i--) {
			result *= i;
		}
		return result;
	}
	
	// 두 수(정수, 실수)를 키보드에서 입력받고 첫번째 나머지 두번째로 계산된 실수값(double)(n1 % n2)을 출력하는 메소드 선언
	void remainder() {
		Scanner sc = new Scanner(System.in);
		System.out.print("x 입력> ");
		double x = Double.parseDouble(sc.nextLine());
		System.out.print("y 입력> ");
		double y = Double.parseDouble(sc.nextLine());
		double result = (double)x % y;
		
		System.out.println("result4: " + result);
	}
	
	// (int)시작값과 뽑을 경우의 수를 매개값으로 입력받고 임의의 수를 뽑아서 리턴하는 메소드 선언(숫자는 연속된 수)
	// ex) 주사위 시작값은 1, 주사위 뽑을 경우의 수는 6 그중 임의의 수 1개. 
	int randomNum(int start, int cases) {
		int result = (int)(Math.random()*cases) + start;
		return result;
	}

}
