package model;

import java.util.LinkedList;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.*;

public class EmailMessage {

    private String from; 
    private LinkedList<String> to; 
    private String subject; 
    private String content; 
    private String mimeType; 
    private LinkedList<String> cc; 
    private LinkedList<String> bcc; 

    private EmailMessage(EmailBuilder builder){

	this.from = builder.from;
	this.to = builder.to;
	this.subject = builder.subject;
	this.content = builder.content;
	this.mimeType = builder.mimeType;
	this.cc = builder.cc ;
	this.bcc = builder.bcc ;

    }

    public String getFrom(){
	return from;
    }

    public LinkedList<String> getTo(){
	return this.to;
    }

    public String getSubject(){
	return subject;
    }

    public String getContent(){
	return content;
    }

    public String getMimeType(){
	return from;
    }

    public LinkedList<String> getCc(){
	return cc;
    }

    public LinkedList<String> getBcc(){
	return bcc;
    }

   
    public static class EmailBuilder {

	private String from;
	private LinkedList<String> to;
	private String subject;
	private String content;
	private String mimeType; 
	private LinkedList<String> cc;
	private LinkedList<String> bcc;

	public EmailBuilder(String from, LinkedList<String> to) {
	    this.from = from;
	    this.to = to;  

	}

	public EmailBuilder addSubject(String subject){
	    this.subject = subject;
	    return this;
	}

	public EmailBuilder addContent (String content){
	    this.content = content;
	    return this;
	}

	public EmailBuilder addMimeType (String mimeType){
	    this.mimeType = mimeType;
	    return this;
	}

	public EmailBuilder addCc (LinkedList<String> cc){
	    this.cc = cc;
	    return this;
	}

	public EmailBuilder addBcc (LinkedList<String> bcc){
	    this.bcc = bcc;
	    return this;
	}

	public EmailMessage build() {
	    EmailMessage emailMessage = new EmailMessage(this);
	    return emailMessage;
	}



    }

    public void send(String pwd, String host, int port) throws MessagingException {

	Authenticator auth = new myAuthenticator(this.getFrom(), pwd);
	Properties props = new Properties();
	props.put("mail.transport.protocol", "smtps"); 
	props.put("mail.smtps.auth", "true");

	Session mailSession = Session.getDefaultInstance(props,auth); 
	mailSession.setDebug(true);

	MimeMessage message = new MimeMessage(mailSession);
	message.setFrom(this.getFrom()); 
	message.setSubject(this.getSubject());
	message.setContent(this.getContent(), "text/plain; charset=ISO-8859-2");
	
	if(this.getTo().size()>0){
	    
	    message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.getTo().get(0)));
	}

	if(this.getCc() != null && this.getCc().size() >0){
	    for(int i=0;i<this.getCc().size();i++)
		message.addRecipient(Message.RecipientType.CC, new InternetAddress(this.getCc().get(i)));
	}

	if(this.getBcc() != null && this.getBcc().size()>0){
	    for(int i=0;i<this.getBcc().size();i++)
		message.addRecipient(Message.RecipientType.BCC, new InternetAddress(this.getBcc().get(i)));
	}

	Transport transport;
        transport = mailSession.getTransport();
	transport.connect(host, port, this.getFrom(), pwd);


	transport.sendMessage(message, message
		.getRecipients(Message.RecipientType.TO));
	transport.close();
    }
}


class myAuthenticator extends Authenticator {
    String username;
    String password;

    
    public myAuthenticator(String username,String password){
	this.username = username;
	this.password = password;
    }

    
    public PasswordAuthentication getPasswordAuthentication() {
	return new PasswordAuthentication(username, password);
    }

}



