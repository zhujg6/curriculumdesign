package com.secondcar.mail;

public class InitMail {

	public static Mail init(String email){
		Mail mail = new Mail();
		mail.setHost("smtp.163.com");
		mail.setSender("15765517018@163.com");
		mail.setReceiver(email);
//		mail.setUsername("�쾴��");
		mail.setName("15765517018@163.com");
		mail.setPassword("MYdream199558");
		mail.setSubject("���ֳ�");
		mail.setMessage("��л��ע�����ǣ�");
		return mail;
	}
	
}
