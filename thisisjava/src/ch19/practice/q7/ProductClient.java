package ch19.practice.q7;

import java.io.IOException;

public class ProductClient {

	public void start() throws IOException {
		
	}
	
	public void stop() {
		
	}
	
	public static void main(String[] args) {
		ProductClient productClient = new ProductClient();
		try {
			productClient.start();
		} catch(IOException e) {
			System.out.println(e.getMessage());
			productClient.stop();
		}
		
	}

}
