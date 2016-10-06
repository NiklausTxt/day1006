package com.day1006.oo.multiThread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;
import java.util.Random;

public class SocketHandler extends Thread {
	SocketDemo socketDemo;
	List<SocketDemo> list;
	

	public SocketHandler(SocketDemo socketDemo, List<SocketDemo> list) {
		this.socketDemo = socketDemo;
		this.list = list;
	}
	
	@Override
	public void run() {
		boolean shouldContinue = true;
		String msg;
		while(shouldContinue){
			try {
				msg = socketDemo.input.readLine();
				System.out.println("Client: " + msg);
				
				if("bye".equals(msg)) break;
				
				
				for(SocketDemo socket:list){
					socket.output.write(msg+"\r");
					socket.output.flush();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}