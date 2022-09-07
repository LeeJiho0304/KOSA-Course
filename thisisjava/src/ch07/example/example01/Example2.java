package ch07.example.example01;

public class Example2 {

	public static void main(String[] args) {
		
		B b = new B();
		A a = b;		
		
		System.out.println("A field1 : " + a.field1);
		System.out.println("A field2 : " + a.field2);
		System.out.println();
		
		a.field1 = 50;
		a.field2 = "Hi";
		
		System.out.println("A field1 : " + a.field1);
		System.out.println("A field2 : " + a.field2);
		System.out.println();
		
		System.out.println("B field1 : " + b.field1);
		System.out.println("B field2 : " + b.field2);
		System.out.println("B field3 : " + b.field3);
		System.out.println();
	}

}

