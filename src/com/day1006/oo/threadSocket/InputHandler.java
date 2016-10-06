package com.day1006.oo.threadSocket;

import java.io.BufferedReader;
import java.io.IOException;

public class InputHandler extends Thread{
	BufferedReader reader;
	ShouldContinue mainthread;
	public boolean shouldCoutinue = true;
	public InputHandler(BufferedReader reader,ShouldContinue mainthread) {
		this.reader = reader;
		this.mainthread=mainthread;
	}
	
	@Override
	public void run() {
		while (shouldCoutinue) {
			try {
				String msg = reader.readLine();
				
				if("bye".equals(msg)){
					shouldCoutinue = false;
					mainthread.setShouldContinue(false);
				} 
				
				System.out.println("收到消息："+msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
