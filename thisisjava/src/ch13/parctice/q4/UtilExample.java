package ch13.parctice.q4;

public class UtilExample {

	public static void main(String[] args) {
		Pair<String, Integer> pair = new Pair<>("홍길동", 35);
		Integer age = Util.getValue2(pair, "홍길동");
		System.out.println(age);
		
		ChildPair<String, Integer> childPair = new ChildPair<>("홍삼원", 20);
		Integer childAge = Util.getValue2(childPair, "홍길동");
		System.out.println(childAge);
		
		//OtherPair 는 Pair를 상속하지 않으므로 컴파일 에러
		/*
		OtherPair<String, Integer> otherPair = new OtherPair<>("홍삼원", 20);
		Integer otherAge = Util.getValue(otherPair, "홍길동");
		System.out.println(otherAge);
		*/
	}

}
