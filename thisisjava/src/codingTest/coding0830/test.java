package codingTest.coding0830;

public class test {

	public static void main(String[] args) {
		int[] data = { 2, 3, 5 };
		int n = data.length;
		int temp = data[n-1];
		data[n-1] = data[0];
//		for(int num : data) {
//			System.out.print(num + " ");
//		}
		for(int i = n-2; i > 0; i--) {
			data[i-1] = data[i];
		}
		data[0] = temp;
		for(int num : data) {
			System.out.print(num + " ");
		}
		
		/*
		 * int[] data = { 2, 3, 5 };
		int n = data.length;
		int temp = data[0];
		data[0] = data[n-1];
		for(int i = n-2; i >=0; i-- ) {
			data[i+1] = data[1];
		}
		data[1] = temp;
		for(int num : data) {
			System.out.print(num + " ");
		}
		 */
		
		
		
	}

}
