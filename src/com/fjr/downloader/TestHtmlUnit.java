package com.fjr.downloader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TestHtmlUnit implements ServletContextListener{

	Thread test = null; 
	Test1 r; 
	
	public  TestHtmlUnit() {
	}
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		if( test == null   ||  ! test.isAlive()) {
			r = new Test1(); 
			test = new Thread(r); 
			test.start();
		}
	}
	
//	contextDestroyed

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		if(test !=  null) {
			try {
				r.terminate();
				test.join();
			}catch(Exception e) {
			
			}
		}
	}

}
