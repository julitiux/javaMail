package javamail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
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

  private MailBuilder() {
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
    return this;
  }

  public MailBuilder body(final String message) {
    return this;
  }

  public void send() {
    System.out.println("sending...");
  }
}
