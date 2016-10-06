package com.day1006.oo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
	public static void main(String[] args) {
		try {
			System.out.println("正在启动服务器...");
			ServerSocket serverSocket  = new ServerSocket(1000);
			System.out.println("服务器启动成功...");
			
			System.out.println("等待连接...");
			Socket socket = serverSocket.accept();
			System.out.println("连接成功...");
			
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			Scanner sc = new Scanner(System.in);
			boolean shouldContinue =true;
			String clientMsg;
			String serverMsg = null;
			while(shouldContinue){
				clientMsg = input.readLine();
				System.out.println("client:"+clientMsg);
				
				if(!"bye".equals(clientMsg)){
					System.out.print("请输入回复：");
					serverMsg = sc.nextLine();
					System.out.println("server:"+serverMsg);
					output.write(serverMsg+"\r");
					output.flush();
				}
				
				if("bye".equals(serverMsg)|| "bye".equals(clientMsg)){
					shouldContinue = false;
				}
			}
			
			
			
			serverSocket.close();
			sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
