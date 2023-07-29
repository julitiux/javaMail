package javamail

import spock.lang.Specification

class FluentMailerSpec extends Specification {

  def "FluentMaile test"() {
    expect:
    FluentMailer.send(mailer -> mailer
      .from("rrodriguez.julio@gmail.com")
      .to("rrodriguez.julio@gmail.com")
      .subject("THIS IS A TEST FROM HELL")
      .body("OH YEAH !")
    )
  }

}
