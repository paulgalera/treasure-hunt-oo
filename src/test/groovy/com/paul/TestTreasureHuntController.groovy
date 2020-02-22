package com.paul

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class TreasureHuntControllerSpec extends Specification {
    @Inject
    @Client("/")
    RxHttpClient client

    void "test basic response"() {
        when:
        HttpRequest req = HttpRequest.GET("/11")
        String rsp = client.toBlocking().retrieve(req)

        then:
        rsp == "Still looking for a treasure...11"
    }

}
