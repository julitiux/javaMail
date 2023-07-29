package javamail;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class FluentMailer {

  private String emailFrom = "rrodriguez.julio@gmail.com";
  private Properties properties;
  private Session session;

  public FluentMailer() {
    properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    properties.setProperty("mail.smtp.starttls.enable", "true");
    properties.setProperty("mail.smtp.port","587");
    properties.setProperty("mail.smtp.user", emailFrom);
    properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
    properties.setProperty("mail.smtp.auth", "true");

    session = Session.getDefaultInstance(properties);
  }

  public FluentMailer from(String address) {
    return this;
  }

  public FluentMailer to(String address) {
    return this;
  }

  public FluentMailer subject(String line) {
    return this;
  }

  public FluentMailer body(String message) {
    return this;
  }

  public void send() {

  }

}
