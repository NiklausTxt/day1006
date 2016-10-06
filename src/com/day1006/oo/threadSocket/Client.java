package com.day1006.oo.threadSocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements ShouldContinue {
	public boolean shouldContinue = true;

	public void start() {
		try {
			System.out.println("等待连接...");
			Socket socket = new Socket("localhost", 1000);
			System.out.println("连接成功...");

			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			Scanner sc = new Scanner(System.in);
			String clientMsg = null;

			InputHandler inputHandler = new InputHandler(input, this);
			inputHandler.start();

			while (shouldContinue) {
				if(shouldContinue){
					clientMsg = sc.nextLine();
					System.out.println("发出消息:" + clientMsg);
					output.write(clientMsg + "\r");
					output.flush();
				}
				

				if ("bye".equals(clientMsg)) {
					shouldContinue = false;
				}
			}

			inputHandler.shouldCoutinue = false;

			sc.close();
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Client client = new Client();
		client.start();
	}

	public void setShouldContinue(boolean shouldContinue) {
		this.shouldContinue = shouldContinue;

	}
}
