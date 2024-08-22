package com.mst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Runner {

	public static void main(String[] args) {
		// MySQL JDBC Connection
		String jdbcUrl = "jdbc:mysql://localhost:3306/customerdb";
		String username = "root";
		String password = "1234";

		try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");

			while (resultSet.next()) {
				System.out.println("Column Value: " + resultSet.getString("cust_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Sending Email
		String to = "DaoudKabha@gmail.com";
		String from = "kabhad82@gmail.com";
		String host = "smtp.gmail.com"; // e.g., smtp.gmail.com

		 Properties properties = System.getProperties();
	        properties.setProperty("mail.smtp.host", host);
	        properties.setProperty("mail.smtp.port", "587");
	        properties.setProperty("mail.smtp.auth", "true");
	        properties.setProperty("mail.smtp.starttls.enable", "true");

		 // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

        protected PasswordAuthentication getPasswordAuthentication() {

            	return new PasswordAuthentication(from , "rzbr spob wrgj woqw");

            }
    
        });

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Test Email from Maven Project");
			message.setText("This is a test email sent from your Maven project!");

			Transport.send(message);
			System.out.println("Email sent successfully!");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

}
