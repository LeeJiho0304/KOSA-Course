package ch19.practice.q7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONArray;
import org.json.JSONObject;


public class ProductServer {
	//필드
	ServerSocket serverSocket;
	ExecutorService threadPool = Executors.newFixedThreadPool(100);
	List<Product> products = Collections.synchronizedList(new ArrayList<>());
	
	int index;
	
	//메소드 : 서버 시작
	public void start() throws IOException {
		serverSocket = new ServerSocket(50001);
		System.out.println("[서버] 시작됨");
		
		Thread thread = new Thread(() -> {
			try {
				while(true) {
					Socket socket = serverSocket.accept();
					SocketClient socketClient = new SocketClient(socket);
				}
			} catch(IOException e) {
				
			}
			
		});
		thread.start();
	}
	
	
	//메소드 : 서버 종료
	public void stop() {
		try {
			serverSocket.close();
			threadPool.shutdownNow();
		} catch (IOException e) {
			System.out.println("[서버] " + e.getMessage());
		}
		
	}
	
	
	//중첩 클래스 : 요청 처리
	class SocketClient {
		//필드
		private Socket socket;
		private DataInputStream dis;
		private DataOutputStream dos;
		
		public SocketClient(Socket socket) {
			try {
				this.socket = socket;
				this.dis = new DataInputStream(socket.getInputStream());
				this.dos = new DataOutputStream(socket.getOutputStream());
				
				receive();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		//메소드 : 요청 받기
		public void receive() {
			threadPool.execute(() -> {
				try {
					String receiveJson = dis.readUTF();
					
					JSONObject request = new JSONObject(receiveJson);
					int menu = request.getInt("menu");
					
					switch(menu) { 
						case 0: //list
							list(request);
							break;
							
						case 1: //Create
							create(request);
							break;
							
						case 2: //Update
							update(request);
							break;
							
						case 3: //Delete
							delete(request);
							break;
							
						case 4: //Exit
							break;
						
					}
				} catch(IOException e) {
					
				}
				
			});
		}
		
		//메소드 : 메뉴0.상품 목록 출력
		public void list(JSONObject request) throws IOException {
			//응답 보내기
			JSONObject data = new JSONObject();
			
			//JSONArray data = new JSONArray();
			for(Product p : products) {
				JSONObject product = new JSONObject();
				product.put("no", p.getNo());
				product.put("name", p.getName());
				product.put("price", p.getPrice());
				product.put("stock", p.getStock());
				request.put("data", product);
				//data.put(product);
			}			
			
			JSONObject response = new JSONObject();
			response.put("status", "success");
			response.put("data", data);
			dos.writeUTF(response.toString());
			dos.flush();
		}
		
		//메소드 : 메뉴1.Create //메소드 : 클라이언트 연결 시 SocketClient 생성 및 추가
		public void create(JSONObject json) throws IOException {
			//요청 처리하기
			JSONObject data = json.getJSONObject("data");
			Product product = new Product();
			product.setNo(++index);
			product.setName(data.getString("name"));
			product.setPrice(data.getInt("price"));
			product.setStock(data.getInt("stock"));
			products.add(product);
			
			//응답 보내기
			JSONObject response = new JSONObject();
			response.put("status", "success");
			response.put("data", new JSONObject());
			dos.writeUTF(response.toString());
			dos.flush();
		}
		
		//메소드 : 메뉴2.Update
		public void update(JSONObject json) {
			
		}
		
		//메소드 : 메뉴3.Delete //메소드 : 클라이언트 연결 종료 시 SocketClient 제거
		public void delete(JSONObject json) {
			
		}
		
		//메소드 : 메뉴4.Exit 종료
		
		
	}
	
	
	//메소드 : main
	public static void main(String[] args) {
		
	}

}
