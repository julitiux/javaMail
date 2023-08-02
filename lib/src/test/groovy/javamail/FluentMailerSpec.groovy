package javamail

import spock.lang.Specification

class FluentMailerSpec extends Specification {

  def "FluentMaile test"() {
    expect:
    FluentMailer.send(mailer -> mailer
      .from(_from)
      .to(_to)
      .subject(_subject)
      .body(_body)
    )
    where:
    _from                        | _to                          | _subject                   | _body
    "rrodriguez.julio@gmail.com" | "rrodriguez.julio@gmail.com" | "THIS IS A TEST FROM HELL" | "OH YEAH !"
  }

}
