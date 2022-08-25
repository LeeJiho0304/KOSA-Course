package ch05.sec11;

public class MainStringArrayArgument {

	public static void main(String[] args) {
		// args.length = 0 이면 배열이 없다.
		if(args.length != 2) {
			System.out.println("프로그램 입력값이 부족");
			System.exit(0);
		}
		
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		
		int result = num1 + num2;
		System.out.printf("%d + %d = %d", num1, num2, result);
		
	}

}
