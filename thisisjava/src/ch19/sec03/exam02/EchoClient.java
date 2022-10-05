package ch19.sec03.exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("localhost", 50001);
			
			System.out.println("[클라이언트] 연결 성공");
			
			//------------------------------------------------------------
			
			/*
			//데이터 보내기
			String sendMessage = "집보내줘!!!ㅜㅜ";
			OutputStream os = socket.getOutputStream();
			byte[] bytes = sendMessage.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("[클라이언트] 데이터를 보냄: " + sendMessage);
			
			//데이터 받기
			InputStream is = socket.getInputStream();
			bytes = new byte[1024];
			int readByteCount = is.read(bytes);
			String receiveMessage = new String(bytes, 0, readByteCount, "UTF-8");
			*/
			
			//데이터 보내기
			String sendMessage = "집보내줘!!!ㅜㅜ";
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(sendMessage);
			dos.flush();
			System.out.println("[클라이언트] 데이터를 보냄: " + sendMessage);
			
			//데이터 받기
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String receiveMessage = dis.readUTF();
			System.out.println("[클라이언트] 데이터를 받음: " + receiveMessage);
			//------------------------------------------------------------
			
			socket.close();
			System.out.println("[클라이언트] 연결 끊음");
			
		} catch (UnknownHostException e) {
			System.out.println("UnknownHostException" + e.toString());
		} catch (IOException e) {
			System.out.println("IOException" + e.toString());
		}
		
		
	}

}
