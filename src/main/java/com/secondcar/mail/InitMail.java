package com.secondcar.mail;

public class InitMail {

	public static Mail init(String email){
		Mail mail = new Mail();
		mail.setHost("smtp.163.com");
		mail.setSender("15765517018@163.com");
		mail.setReceiver(email);
//		mail.setUsername("朱敬国");
		mail.setName("15765517018@163.com");
		mail.setPassword("MYdream199558");
		mail.setSubject("二手车");
		mail.setMessage("感谢您注册我们！");
		return mail;
	}
	
}
