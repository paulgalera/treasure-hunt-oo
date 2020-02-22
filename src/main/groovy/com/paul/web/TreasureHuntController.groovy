package com.paul.web

import com.paul.service.TreasureHuntService
import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.http.MediaType

import javax.inject.Inject

@CompileStatic
@Controller("/")
class TreasureHuntController {

    TreasureHuntService treasureHuntService

    @Inject
    TreasureHuntController(TreasureHuntService treasureHuntService) {
        this.treasureHuntService = treasureHuntService
    }

    @Get("{startPoint}")
    @Produces(MediaType.TEXT_PLAIN)
    String index(int startPoint) {
        treasureHuntService.findTreasure(startPoint)
    }
}