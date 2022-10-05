package ch19.sec03.exam01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
	private static ServerSocket serverSocket = null;
	
	public static void main(String[] args) {
		System.out.println("-------------------------------------------------");
		System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 Enter 키를 입력하세요.");
		System.out.println("-------------------------------------------------");

		//TCP 서버 시작
		startServer();
	
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String key = sc.nextLine();
			if(key.toLowerCase().equals("q")) {
				break;
			}
		}
		sc.close();
		
		//TCP 서버 종료
		stopServer();

	}
	
	public static void startServer() {
		//작업 스레드 정의
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					//ServerSocket 생성 및 port 바인딩
					serverSocket = new ServerSocket(50001);
					System.out.println("[서버] 시작됨");
					
					//다른 클라이언트의 요청을 계속 받기위해 무한 루프
					while(true) {
						System.out.println("\n [서버] 연결 요청을 기다림\n");
						//연결 수락
						Socket socket = serverSocket.accept();
						
						//연결된 클라이언트 정보
						InetSocketAddress ias = (InetSocketAddress) socket.getRemoteSocketAddress();
						String clientIp = ias.getHostString();
						System.out.println("[서버] " + clientIp + "의 연결 요청을 수락함");
						
						//연결 끊기
						socket.close();
						System.out.println("[서버] " + clientIp + "의 연결을 끊음");
					}
				} catch (IOException e) {
					System.out.println("[서버] " + e.toString());
				}
			}
		};
		
		thread.start();
		
	}
	
	public static void stopServer() {
		try {
			//ServerSocket을 닫고 Port 언바인딩
			serverSocket.close();
			System.out.println("[서버] 종료됨");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
