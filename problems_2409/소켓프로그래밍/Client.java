package problems_2409.소켓프로그래밍;
// Client.java
import java.net.*;
import java.io.*;

public class Client {
	public static void main(String[] args) {
		try {
			Socket clientSocket = new Socket("localhost", 12345); // 서버에 연결
			System.out.println("서버에 연결되었습니다.");

			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			out.println("Hello from client!");

			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String serverMessage = in.readLine();
			System.out.println("서버 메시지: " + serverMessage);

			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}