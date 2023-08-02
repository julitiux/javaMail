package javamail

import spock.lang.Specification

class FluentMailerSpec extends Specification {

  def "FluentMailer success"() {
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
    null                         | "rrodriguez.julio@gmail.com" | "THIS IS A TEST FROM HELL" | "OH YEAH !"
    "rrodriguez.julio@gmail.com" | "rrodriguez.julio@gmail.com" | null                       | "OH YEAH !"
    "rrodriguez.julio@gmail.com" | "rrodriguez.julio@gmail.com" | "THIS IS A TEST FROM HELL" | null
  }

  def "FluentMailer fails"() {
    when:
    FluentMailer.send(mailer -> mailer
      .from(_from)
      .to(_to)
      .subject(_subject)
      .body(_body)
    )
    then:
    thrown(RuntimeException)
    where:

    _from                        | _to                          | _subject                   | _body
    null                         | null                         | null                       | null
    "rrodriguez.julio@gmail.com" | null                         | "THIS IS A TEST FROM HELL" | "OH YEAH !"

  }

}
