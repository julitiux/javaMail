package javamail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EnvioCorreos {

  String emailFrom = "rrodriguez.julio@gmail.com";
  String passwordFrom = "sccukptjbdbwbgty";
  String emailTo = "rrodriguez.julio@gmail.com";
  String subject = "envio de correo test";
  String content = "contenido de correo test";

  private Properties properties;
  private Session session;
  private MimeMessage mimeMessage;

  public EnvioCorreos(){
    properties = new Properties();
  }

  private void createEmail(){
    properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    properties.setProperty("mail.smtp.starttls.enable", "true");
    properties.setProperty("mail.smtp.port","587");
    properties.setProperty("mail.smtp.user", emailFrom);
    properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
    properties.setProperty("mail.smtp.auth", "true");

    session = Session.getDefaultInstance(properties);

    mimeMessage = new MimeMessage(session);
    try {
      mimeMessage.setFrom(new InternetAddress(emailFrom));
      mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
      mimeMessage.setSubject(subject);
      mimeMessage.setText(content, "ISO-8859-1", "html");
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }

  }

  public void sendEmail(){
    createEmail();
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
