package com.day1006.oo.threadSocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server implements ShouldContinue {
	public boolean shouldContinue = true;

	public void start() {
		try {
			System.out.println("��������������...");
			ServerSocket serverSocket = new ServerSocket(1000);
			System.out.println("�����������ɹ�...");

			System.out.println("�ȴ�����...");
			Socket socket = serverSocket.accept();
			System.out.println("���ӳɹ�...");

			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			Scanner sc = new Scanner(System.in);
			String serverMsg = null;

			InputHandler inputHandler = new InputHandler(input,this);
			inputHandler.start();

			while (shouldContinue) {
				// clientMsg = input.readLine();
				// System.out.println("client:"+clientMsg);
				if(shouldContinue){
					serverMsg = sc.nextLine();
					System.out.println("������Ϣ:" + serverMsg);
					output.write(serverMsg + "\r");
					output.flush();
				}
				
				if ("bye".equals(serverMsg)) {
					shouldContinue = false;
				}
			}

			inputHandler.shouldCoutinue = false;

			serverSocket.close();
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}

	public void setShouldContinue(boolean shouldContinue) {
		this.shouldContinue = shouldContinue;

	}
}
