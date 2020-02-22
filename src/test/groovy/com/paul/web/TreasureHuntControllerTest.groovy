package com.paul.web

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.exceptions.HttpClientException
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class TreasureHuntControllerTest extends Specification {
    @Inject
    @Client("/")
    RxHttpClient client

    def "testAllowedIntParam"() {
        when:
        HttpRequest req = HttpRequest.GET("/11")
        String rsp = client.toBlocking().retrieve(req)

        then:
        rsp.toString() == "[11, 34, 42, 15, 25, 31, 54, 13, 32, 45, 35, 23, 43, 51, 21, 14, 41, 33, 52]"
    }

    def "testWrongIntParam"() {
        when:
        HttpRequest req = HttpRequest.GET("/18")
        String rsp = client.toBlocking().retrieve(req)

        then:
        rsp == "Holy smoke...18 is a wrong index for a 5x5 TreasureMap!"
    }

    void "testStringParam"() {
        when:
        HttpRequest req = HttpRequest.GET("/crap")
        client.toBlocking().retrieve(req)

        then:
        thrown(HttpClientException)
    }

}
