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
			System.out.println("正在启动服务器...");
			ServerSocket serverSocket = new ServerSocket(100);
			System.out.println("服务器启动成功...");
			System.out.println("等待连接...");
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("连接成功");
				SocketDemo socketDemo = new SocketDemo(socket);
				list.add(socketDemo);
				System.out.println("添加成功");
				SocketHandler handler = new SocketHandler(socketDemo,list);
				handler.start();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
