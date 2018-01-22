package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.service.MemberService;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("test/main/init.xml");
		
		MemberService mService = context.getBean(MemberService.class);
		
		mService.insert();
		System.out.println("-------");
		mService.select();
	}
}
