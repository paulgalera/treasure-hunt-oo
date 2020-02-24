package com.paul.domain

import io.micronaut.test.annotation.MicronautTest
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class TreasureHunterTest extends Specification {

    @Shared
    TreasureHunter treasureHunter

    def setupSpec() {
        treasureHunter = new TreasureHunter(TreasureMap.getMAP() as ArrayList<ArrayList<Integer>>)
    }

    def "testDigForTreasure"() {
        when:
        List<Integer> path = treasureHunter.digForTreasure(14, new ArrayList<Integer>())

        then:
        path.size() > 0
        path.toString() == "[14, 41, 33, 52]"
    }

    def "testGoCheckInitialSpotsTreasureFound"() {
        when:
        List<Integer> path = treasureHunter.goHuntingForTreasure(52)

        then:
        path.size() == 1
        path.toString() == "[52]"
    }

}
