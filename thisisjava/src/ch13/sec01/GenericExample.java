package ch13.sec01;

public class GenericExample {

	public static void main(String[] args) {
		Box<String> box1 = new Box<>();
		box1.content = "안녕하세요";  //자동 boxing
		String str = box1.content; //자동 unboxing
		System.out.println(str);
		
		Box<Integer> box2 = new Box<>();
		box2.content = 100;        //자동 boxing
		int value = box2.content;  //자동 unboxing
		System.out.println(value);
	}

}
