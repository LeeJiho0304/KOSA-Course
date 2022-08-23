package ch02.sec08;

public class CastingExample {

	public static void main(String[] args) {
		// int -> byte
		int var1 = 10;
		byte var2 = (byte) var1;
		System.out.println(var2);
		
		// long -> int
		long var3 = 300;
		int var4 = (int) var3;
		System.out.println(var4);
		
		// int -> char
		int var5 = 65;
		char var6 = (char) var5;
		System.out.println(var6);
		
		// double -> int
		double var7 = 3.14;
		int var8 = (int) var7;
		System.out.println(var8);
		
		// byte -> char
		byte var9 = 65;
		char var10 = (char) var9;
		System.out.println(var10);
	}

}
