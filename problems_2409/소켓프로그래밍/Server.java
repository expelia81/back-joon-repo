package problems_2409.소켓프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(12345); // 포트 번호 지정
			System.out.println("서버가 시작되었습니다. 포트: 12345");

			Socket clientSocket = serverSocket.accept(); // 클라이언트 연결 수락
			System.out.println("클라이언트가 연결되었습니다.");

			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

			String clientMessage = in.readLine();
			System.out.println("클라이언트 메시지: " + clientMessage);

			out.println("Hello from server!");

			clientSocket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
