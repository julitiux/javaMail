package javamail

import spock.lang.Specification

class MailBuilderSpec extends Specification {

  def "MailBuilder Test"() {
    expect:
    new MailBuilder()
      .from(_from)
      .to(_to)
      .subject(_subject)
      .body(_body)
      .send()
    where:
    _from                        | _to                          | _subject                   | _body
    "rrodriguez.julio@gmail.com" | "rrodriguez.julio@gmail.com" | "THIS IS A TEST FROM HELL" | "OH YEAH !"
    null                         | "rrodriguez.julio@gmail.com" | "THIS IS A TEST FROM HELL" | "OH YEAH !"
    "rrodriguez.julio@gmail.com" | "rrodriguez.julio@gmail.com" | null                       | "OH YEAH !"
    "rrodriguez.julio@gmail.com" | "rrodriguez.julio@gmail.com" | "THIS IS A TEST FROM HELL" | null
  }

}
