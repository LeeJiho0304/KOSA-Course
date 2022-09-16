package ch11.sec03.exam03;

public class ExceptionHandlingExample {

	public static void main(String[] args) {
		String[] array = {"10", "1oo", null, "2000"};
		
		for(int i = 0; i <= array.length; i++) {
			try {
				System.out.println(array[i].length());
				int value = Integer.parseInt(array[i]);
			} catch(NumberFormatException e) {
				System.out.println("숫자로 변환할 수 없음: " + e.getMessage());
			} catch(NullPointerException | ArrayIndexOutOfBoundsException e) {
				System.out.println("데이터에 문제가 있음: " + e.getMessage());
			} catch(Exception e) {
				System.out.println("예상치 못한 예외가 발생했습니다.");
			}
		}
	}

}
