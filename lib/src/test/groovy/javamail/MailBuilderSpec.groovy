package javamail

import spock.lang.Specification

class MailBuilderSpec extends Specification {

  def "MailBuilder Test"() {
    expect:
    new MailBuilder()
      .from("rrodriguez.julio@gmail.com")
      .to("rrodriguez.julio@gmail.com")
      .subject("this is the subject")
      .body("this is the body")
      .send()
  }

}
