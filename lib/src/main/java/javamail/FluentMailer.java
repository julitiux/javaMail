package javamail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class FluentMailer {

  private String emailFrom = "rrodriguez.julio@gmail.com";
  String passwordFrom = "sccukptjbdbwbgty";
  private Properties properties;
  private Session session;
  private MimeMessage mimeMessage;

  public FluentMailer() {
    properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    properties.setProperty("mail.smtp.starttls.enable", "true");
    properties.setProperty("mail.smtp.port", "587");
    properties.setProperty("mail.smtp.user", emailFrom);
    properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
    properties.setProperty("mail.smtp.auth", "true");
    session = Session.getDefaultInstance(properties);
    mimeMessage = new MimeMessage(session);
  }

  public FluentMailer from(String address) {
    try {
      mimeMessage.setFrom(new InternetAddress(address));
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
    return this;
  }

  public FluentMailer to(String address) {
    try {
      mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(address));
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
    return this;
  }

  public FluentMailer subject(String line) {
    try {
      mimeMessage.setSubject(line);
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
    return this;
  }

  public FluentMailer body(String message) {
    try {
      mimeMessage.setText(message, "ISO-8859-1", "html");
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
    return this;
  }

  public void send() {

  }


  public void sending(){
    try {
      Transport transport = session.getTransport("smtp");
      transport.connect(emailFrom, passwordFrom);
      transport.sendMessage(mimeMessage, mimeMessage.getRecipients(Message.RecipientType.TO));
      transport.close();

    } catch (NoSuchProviderException e) {
      throw new RuntimeException(e);
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }

}
