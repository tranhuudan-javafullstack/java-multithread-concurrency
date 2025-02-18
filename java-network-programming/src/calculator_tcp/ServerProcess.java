package calculator_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class ServerProcess extends Thread {
	Socket socket;
	BufferedReader netIn;
	PrintWriter netOut;
	int operator1;
	int operator2;
	char operator;

	public ServerProcess(Socket socket) throws IOException {
		this.socket = socket;
		netIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		netOut = new PrintWriter(socket.getOutputStream(), true);
		netOut.println("welcom to computer process");
	}

	@Override
	public void run() {
		String request, response;
		try {
			while (true) {
				request = netIn.readLine();
				if (request.equalsIgnoreCase("EXIT"))
					break;
				try {
					// slit
					requestAnal(request);
					// do operator

					double result = doRequest();
					response = request + "=" + result;
					netOut.println(response);
				} catch (MyException e) {
					netOut.println(e.getMessage());
				}
			}
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void requestAnal(String request) throws MyException {
		StringTokenizer st = new StringTokenizer(request, "+-/*");
		String str1, str2;
		 str1 = st.nextToken();
	
		try {
			str2 = st.nextToken();	
		
		} catch (NoSuchElementException e) {
			String line = request.trim();
			char c = line.charAt(0);
			if (c == '+' || c == '-' || c == '*' || c == '/')
				throw new MyException("Thieu toán tử đầu tiên");
			else
				throw new MyException("Thiếu toán tử thứ 2");
			
		}
		this.operator = request.charAt(str1.length());
		try {
			this.operator1 = Integer.parseInt(str1.trim());
		} catch (NumberFormatException e) {
			throw new MyException("Toán hạng 1 không phải số");
		}
		try {
			this.operator2 = Integer.parseInt(str2.trim());
		} catch (NumberFormatException e) {
			throw new MyException("Toán hạng 2 không phải số");
		}
		
		


	}

	private double doRequest() {
		double res = 0;
		switch (this.operator) {
		case '+':
			res = this.operator1 + this.operator2;
			break;
		case '-':
			res = this.operator1 - this.operator2;
			break;
		case '*':
			res = this.operator1 * this.operator2;
			break;
		case '/':
			res = this.operator1 / this.operator2;
			break;

		}
		return res;
	}

}
