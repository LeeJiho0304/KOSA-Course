package ch07.example.example01;

public class Example1 {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		
		a.field1 = 30;
		a.field2 = "Hi";
		
		System.out.println("B field1 : " + b.field1);
		System.out.println("B field2 : " + b.field2);
		System.out.println("B field3 : " + b.field3);
		System.out.println();
		
		b.field1 = 100;
		b.field2 = "Bye";
		b.field3 = 200;

		
		System.out.println("A field1 : " + a.field1);
		System.out.println("A field2 : " + a.field2);
		System.out.println();
		
		System.out.println("B field1 : " + b.field1);
		System.out.println("B field2 : " + b.field2);
		System.out.println("B field4 : " + b.field3);
		System.out.println();
		
		System.out.println("C field1 : " + c.field1);
		System.out.println("C field3 : " + c.field3);
		System.out.println("C field6 : " + c.field6);
		System.out.println();
	}

}
