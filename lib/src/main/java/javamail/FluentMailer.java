package javamail;

public class FluentMailer {

  public FluentMailer() {
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
