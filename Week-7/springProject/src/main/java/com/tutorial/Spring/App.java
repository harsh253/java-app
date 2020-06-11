package com.tutorial.Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("mobileContext.xml");
		Mobile mob = (Mobile)factory.getBean("mobile");
		mob.display();
	}

}
