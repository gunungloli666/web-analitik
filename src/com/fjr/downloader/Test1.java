package com.fjr.downloader;

public class Test1 implements Runnable{
	
	boolean running =  true; 
	
	
	public void terminate() {
		running = false; 
	}

	@Override
	public void run() {

		while(running) {
			System.out.println("start thread"); 
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	

}
