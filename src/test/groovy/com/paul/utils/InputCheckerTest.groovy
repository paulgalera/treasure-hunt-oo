package com.paul.utils

import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

@MicronautTest
class InputCheckerTest extends Specification {
    def "isInputOkForInts"() {
        when:
        boolean res = InputChecker.isInputOk(input)

        then:
        res == expected

        where:
        input | expected
        11    | true
        55    | true
        10    | false
        56    | false
        16    | false
    }

    def "isInputOkForOtherClasses"() {
        when:
        boolean res = InputChecker.isInputOk(input)

        then:
        res == expected

        where:
        input | expected
        null  | false
        "a"   | false
        "n/a" | false
        12L   | false
        10.4f | false
        56.6  | false
    }
}
