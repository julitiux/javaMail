package javamail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Properties;

public class MailBuilder {

  final static String emailFrom = "rrodriguez.julio@gmail.com";
  final static String passwordFrom = "erwfqldtgkkxnrar";
  private Properties properties = new Properties();
  private static Session session;
  private static MimeMessage mimeMessage;

  public MailBuilder() {
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


  public MailBuilder from(final String address) {
    Optional<String> optionalAddress = Optional.ofNullable(address);
    try {
      mimeMessage.setFrom(new InternetAddress(optionalAddress.orElse(emailFrom)));
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
    return this;
  }

  public MailBuilder to(final String address) {
    Optional<String> optionalAddress = Optional.ofNullable(address);
    optionalAddress.orElseThrow(NoSuchElementException::new);
    try {
      mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(optionalAddress.get()));
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
    return this;
  }

  public MailBuilder subject(final String line) {
    Optional<String> optionalSubject = Optional.ofNullable(line);
    try {
      mimeMessage.setSubject(optionalSubject.orElse("(No Subject)"));
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
    return this;
  }

  public MailBuilder body(final String message) {
    Optional<String> optionalBody = Optional.ofNullable(message);
    try {
      mimeMessage.setText(optionalBody.orElse("No Content"), "ISO-8859-1", "html");
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
    return this;
  }

  public void send() {
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
