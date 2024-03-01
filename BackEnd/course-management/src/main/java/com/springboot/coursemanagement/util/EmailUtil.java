package com.springboot.coursemanagement.util;

public interface EmailUtil {
	
	void sendEmail(String toAddress, String subject, String body);

}
