package ch18.sec03.exam03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {

	public static void main(String[] args) {
		String originalFileName = "C:/Temp/test.jpg";
		String targetFileName = "C:/Temp/test2.jpg";
		
		try(InputStream is = new FileInputStream(originalFileName);
			OutputStream os = new FileOutputStream(targetFileName)) {
			
			byte[] data = new byte[1024];
			
			while(true) {
				int num = is.read(data);
				if(num == -1) break;
				os.write(data, 0, num);
			}
			//is.transferTo(os);   // 19~25라인
			
			os.flush();
			os.close();
			is.close();
			System.out.println("복사 성공");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
