package ch19.sec07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.json.JSONObject;

public class SocketClient {
	//필드
	ChatServer chatServer;
	Socket socket;
	String chatName;
	String clientIp;
	DataInputStream dis;
	DataOutputStream dos;

	//생성자
	public SocketClient(ChatServer chatServer, Socket socket) {
		try {
			this.chatServer = chatServer;
			this.socket = socket;
			this.dis = new DataInputStream(socket.getInputStream());
			this.dos = new DataOutputStream(socket.getOutputStream());
			
			InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
			this.clientIp = isa.getHostString();
			receive();
		} catch(Exception e) {
			
		}
		
	}
	
	//메소드 : JSON(data) 받기
	public void receive() {
		
		//밖에서 try-catch 를 하면 위에 socketClient 생성자를 호출하는 thread
		chatServer.threadPool.execute(() -> {
			//람다식의 this는 익명구현객체를 가르키는게 아니라 해당 클래스 즉 SocketClient
			try { //threadPool에 있는 thread
				while(true) {
					String receive = dis.readUTF();
					
					//{"command":"incoming", "data":"chatName"}
					//{"command":"message", "data":"보낼 내용"}
					JSONObject jsonObject = new JSONObject(receive);
					String command = jsonObject.getString("command");
					
					//클라이언트의 요청사항
					switch(command) {
						case "incoming": 
							this.chatName = jsonObject.getString("data");
							chatServer.sendToAll(this, "들어오셨습니다.");
							chatServer.addSocketClient(this);
							break;
							
						case "message": 
							String message = jsonObject.getString("data");
							chatServer.sendToAll(this, message);
							
							break;
					}
				}
			} catch(IOException e) {
				//클라이언트와 연결이 끊겼을 때 (클라이언트가 채팅을 종료할 경우)
				chatServer.sendToAll(this, "나가셨습니다.");
				chatServer.removeSocketClient(this);
			}
			
		});
	}

	
	//메소드 : JSON(data) 보내기
	public void send(String json) {
		try {
			dos.writeUTF(json);
			dos.flush();
		} catch (IOException e) {
		}
		
	}
	
	//메소드 : 연결 종료. 클라이언트 소켓 닫기
	public void close() {
		try {
			socket.close();
		} catch (IOException e) {
		}
	}
	
	
}
