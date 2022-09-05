package ch06.sec10.exam01;

public class CalculatorExample {

	public static void main(String[] args) {
		double result1 = 10 * 10 % Calculator.pi;
		int result2 = Calculator.plus(10, 5);
		int result3 = Calculator.minus(10, 5);
		
		/* 이클립스에서 실행은 되지만 정적요소는 클래스 이름으로 접근하는 것이 좋음
		Calculator myCalcu = new Calculator();
		double result4 = 10 * 10 % myCalcu.pi;
		int result5 = myCalcu.plus(10, 5);
		int result6 = myCalcu.minus(10, 5);
		*/
		
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
		System.out.println("result3 : " + result3);
	}

}
