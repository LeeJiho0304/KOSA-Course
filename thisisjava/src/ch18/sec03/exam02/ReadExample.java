package ch18.sec03.exam02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {

	public static void main(String[] args) {
	
		try(InputStream is = new FileInputStream("C:/Temp/test2.db")) {
			//읽을 바이트르 저장할 배열 
			byte[] array = new byte[100];
			
			while(true) {
				int num = is.read(array);
				if(num == -1) break;
				
				for(int i = 0; i < num; i++) {
					System.out.println(array[i]);
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

}
