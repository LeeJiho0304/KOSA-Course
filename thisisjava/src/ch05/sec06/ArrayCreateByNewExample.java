package ch05.sec06;

public class ArrayCreateByNewExample {

	public static void main(String[] args) {
		// int type 배열 선언
		int[] arr1 = new int[3];
		for(int i=0; i<arr1.length; i++) {
			System.out.print("arr1[" + i + "] : " + arr1[i]);
			if(i==arr1.length-1) {
				System.out.print(" ");
			} else {
				System.out.print(", ");
			}
		}
		System.out.println();
		
		for(int i=0; i<arr1.length; i++) {
			arr1[i] = i;
			System.out.print("arr1[" + i + "] : " + arr1[i]);
			if(i==arr1.length-1) {
				System.out.print(" ");
			} else {
				System.out.print(", ");
			}
		}
		System.out.println();
		
		System.out.println();
		
		// double type 배열 선언
		double[] arr2 = new double[3];
		for(int i=0; i<arr2.length; i++) {
			System.out.print("arr2[" + i + "] : " + arr2[i]);
			if(i==arr2.length-1) {
				System.out.print(" ");
			} else {
				System.out.print(", ");
			}
		}
		System.out.println();
		
		for(int i=0; i<arr2.length; i++) {
			arr2[i] = i;
			System.out.print("arr2[" + i + "] : " + arr2[i]);
			if(i==arr2.length-1) {
				System.out.print(" ");
			} else {
				System.out.print(", ");
			}
		}
		System.out.println();

		System.out.println();
		
		// String type 배열 선언
		String[] arr3 = new String[3];
		for(int i=0; i<arr3.length; i++) {
			System.out.print("arr3[" + i + "] : " + arr3[i]);
			if(i==arr3.length-1) {
				System.out.print(" ");
			} else {
				System.out.print(", ");
			}
		}
		System.out.println();
		
		for(int i=0; i<arr3.length; i++) {
			arr3[i] = String.valueOf(i);
			System.out.print("arr3[" + i + "] : " + arr3[i]);
			if(i==arr3.length-1) {
				System.out.print(" ");
			} else {
				System.out.print(", ");
			}
		}
		System.out.println();
		
	}

}
