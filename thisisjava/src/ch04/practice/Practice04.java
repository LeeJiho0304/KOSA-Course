package ch04.practice;

public class Practice04 {

	public static void main(String[] args) {
		int num1;
		int num2;

		do {
			num1 = (int)(Math.random()*6) + 1;
			num2 = (int)(Math.random()*6) + 1;
			if(num1 + num2 == 5)	{
				System.out.println("*** 눈1, 눈2의 합이 5인 경우 ***");
			}
			System.out.println("(" + num1 + ", " + num2 + ")");
		} while(( num1+num2) != 5);
	}

}
