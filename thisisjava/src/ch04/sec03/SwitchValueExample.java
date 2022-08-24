package ch04.sec03;

public class SwitchValueExample {

	public static void main(String[] args) {
		String grade = "B";
		
		// Java 11이전 문법
		int score1 = 0;
		switch(grade)	{
			case "A":
				score1 = 100;
				break;
			case "B":
				int result = 100 - 20;
				score1 = result;
				break;
			default:
				score1 = 60;
		}
		System.out.println("score1: " + score1);
		
		// Java 12부터 가능
		int score2 = switch(grade) {
			case "A" -> 100;
			case "B" -> {
				int result = 100 - 20;
				yield result;
			}
			default -> 60; // 생략 불가능
		};
		System.out.println("score2: " + score1 );
	}

}
