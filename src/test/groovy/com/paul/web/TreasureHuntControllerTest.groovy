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

    def "testIntParam"() {
        when:
        HttpRequest req = HttpRequest.GET("/11")
        String rsp = client.toBlocking().retrieve(req)

        then:
        rsp == "Still looking for a treasure...11"
    }

    void "testStringParam"() {
        when:
        HttpRequest req = HttpRequest.GET("/crap")
        String rsp = client.toBlocking().retrieve(req)

        then:
        thrown(HttpClientException)
    }

}
