package javamail

import spock.lang.Specification

class EmailSenderSpec extends Specification {

  def "test mailer"() {
    given:
    EnvioCorreos envioCorreos = new EnvioCorreos()
    expect:
    envioCorreos.sendEmail()
  }

}
