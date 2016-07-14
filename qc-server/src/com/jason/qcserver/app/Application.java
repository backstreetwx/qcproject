package com.jason.qcserver.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tanukisoftware.wrapper.WrapperListener;
import org.tanukisoftware.wrapper.WrapperManager;

public class Application implements WrapperListener{
	
	private Logger logger = LoggerFactory.getLogger(Application.class);
	
	private AbstractApplicationContext context = null;

	@Override
	public void controlEvent(int event) {
		
	}

	@Override
	public Integer start(String[] args) {
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		logger.info("application is runing...");
		return null;
	}

	@Override
	public int stop(int exitCode) {
		if(context != null) {
			context.close();
		}
		logger.info("application is stoped...");
		return 0;
	}

	public static void main(String[] args) {
		WrapperManager.start(new Application(), args);
	}
}
