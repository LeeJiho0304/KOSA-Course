package ch05.sec05;

public class SubStringExample {

	public static void main(String[] args) {
		String ssn = "880815-1234567";
		
		String firstNum = ssn.substring(0, ssn.indexOf("-"));
		System.out.println(firstNum);
		
		String secondNum = ssn.substring(ssn.indexOf("-") + 1);
		System.out.println(secondNum);
		
		// - 로 문자열 분리
		String[] ssn1 = ssn.split("-");
		System.out.println(ssn1[0]);
		System.out.println(ssn1[1]);
		
	}

}
