package ch05.practice;

public class Practice07 {

	public static void main(String[] args) {
		int[] array = { 1, 5, 3, 8, 2 };
		
		int max = 0;
		for(int i=0; i<array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		
		//향상된 for문
		/*
		for(int num : array) {
			if(num > max) {
				max = num;
			}
		}
		*/
		
		System.out.println("최대값 : " + max);
	}

}
