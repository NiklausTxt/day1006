package com.day1006.oo.multiThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	public static void main(String[] args) {
		List<SocketDemo> list = new ArrayList<>();
		
		try {
			System.out.println("��������������...");
			ServerSocket serverSocket = new ServerSocket(100);
			System.out.println("�����������ɹ�...");
			System.out.println("�ȴ�����...");
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("���ӳɹ�");
				SocketDemo socketDemo = new SocketDemo(socket);
				list.add(socketDemo);
				System.out.println("��ӳɹ�");
				SocketHandler handler = new SocketHandler(socketDemo,list);
				handler.start();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
