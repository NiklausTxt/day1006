package com.day1006.oo.multiThread;

import java.io.BufferedReader;
import java.io.IOException;

public class InputHandler extends Thread{
	BufferedReader reader;
	
	public boolean shouldCoutinue = true;
	public InputHandler(BufferedReader reader) {
		this.reader = reader;
		
	}
	
	@Override
	public void run() {
		while (shouldCoutinue) {
			try {
				String msg = reader.readLine();
				
				if("bye".equals(msg)){
					shouldCoutinue = false;
				} 
				
				System.out.println("�յ���Ϣ��"+msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
