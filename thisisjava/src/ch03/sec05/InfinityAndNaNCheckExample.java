package ch03.sec05;

import java.util.Scanner;

public class InfinityAndNaNCheckExample {
	public static void main(String[] args)	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("x: ");
		int x = Integer.parseInt(sc.nextLine());
		
		System.out.print("y: ");
		double y = Double.parseDouble(sc.nextLine());
		
		double z = x % y;
		
		if(Double.isInfinite(z) || Double.isNaN(z))	{
			System.out.println("값 산출 불가");
		} else {
			System.out.println("z: " + z);
			System.out.println("z + 2: " + (z+2));
		}
		
//		int result = 5 / 0;  // 정수 연산을 하면 예외오류가 발생(실행 오류)
		double result = 5 / 0.0;  // 실수 연산을 하면 오류는 발생하지 않지만 infinity 또는 NaN이 생길 수 있다.
	}
}
