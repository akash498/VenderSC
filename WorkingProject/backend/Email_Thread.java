package backend;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/* INFORMATION ON HOW TO GET THIS THREAD WORKING
 * 
 * 1. Add the JARs mailapi.jar and smtp.jar to your java build path AND deployment assembly.
 * 
 * 2. Enter the password for vendorsc2019@gmail.com on line 51
 * 
 * 3. When you want to send an email, simply call the constructor using the correct parameters
 * 
 */

public class Email_Thread extends Thread {
	
	String recipiant, message, subject=null;
	
	
	// first parameter is the recipiants email, second parameter is the message/ body of the email
	public Email_Thread(String r, String m) {
		
		recipiant = r;
		message = m;
		start();
	}
	
	// first parameter is the recipiants email, second parameter is the message/ body of the email, third parameter is the subject of the email
	public Email_Thread(String r, String m, String s) {
		
		recipiant = r;
		message = m;
		subject = s;
		start();
	}
	
	public void run() {
		
		final String username = "vendorsc2019@gmail.com";
		
        // insert password here
        final String password = "csci2012019";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("vendorsc2019@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(recipiant)
            );
            
            // this can be updated if you would like a different subject 
            if(subject==null) {
            	message.setSubject("VENDORSC Business Update");
            }
            else {
            	message.setSubject(subject);
            }
            
            message.setText(this.message);

            Transport.send(message);

            System.out.println("Email successfully sent!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
		
	}

}
