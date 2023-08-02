package javamail;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
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
    return this;
  }

  public MailBuilder to(final String address) {
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
