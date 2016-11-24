package com.secondcar.mail;

import java.io.File;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;


public class MailUtil {

	
	public static boolean send(Mail mail){
		HtmlEmail email = new HtmlEmail();
		try {
			email.setHostName(mail.getHost());
			email.setCharset(Mail.ENCODEING);
			email.addTo(mail.getReceiver());
			email.setFrom(mail.getSender(), mail.getName());
			email.setAuthentication(mail.getName(), mail.getPassword());
			email.setSubject(mail.getSubject());
			email.setMsg(mail.getMessage());
			email.send();
			return true;
		} catch (EmailException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static void main(String[] args) {
		File file = new File("/javaMail/Mail.java");
	}
}
