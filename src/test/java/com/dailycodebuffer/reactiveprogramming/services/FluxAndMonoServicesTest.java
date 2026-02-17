package com.dailycodebuffer.reactiveprogramming.services;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class FluxAndMonoServicesTest {

    FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();

    //FLUX
    @Test
    void fruitsFlux() {
        var fruitsFlux = fluxAndMonoServices.fruitsFlux();
        StepVerifier.create(fruitsFlux)
                .expectNext("Mango", "Orange", "Banana")
                .verifyComplete();
    }

    //MONO
    @Test
    void fruitsMono() {
        var fruitsMono = fluxAndMonoServices.fruitsMono();
        StepVerifier.create(fruitsMono)
                .expectNext("Mango")
                .verifyComplete();
    }

    @Test
    void fruitsMonoFlatMap() {
        var fruitsFlux = fluxAndMonoServices.fruitsMonoFlatMap();
        StepVerifier.create(fruitsFlux)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void fruitsMonoFlatMapMany() {
        var fruitsFlux = fluxAndMonoServices.fruitsMonoFlatMapMany();
        StepVerifier.create(fruitsFlux)
                .expectNextCount(5)
                .verifyComplete();
    }

    //TEST OPERATORI
    @Test
    void fruitsFluxMap() {
        var fruitsFlux = fluxAndMonoServices.fruitsFluxMap();
        StepVerifier.create(fruitsFlux)
                .expectNext("MANGO", "ORANGE", "BANANA")
                .verifyComplete();
    }

    @Test
    void fruitsFluxFilter() {
        var fruitsFlux = fluxAndMonoServices.fruitsFluxFilter(5);
        StepVerifier.create(fruitsFlux)
                .expectNext("Orange", "Banana")
                .verifyComplete();
    }


    @Test
    void fruitsFluxMapFilter() {
        var fruitsFlux = fluxAndMonoServices.fruitsFluxMapFilter(5);
        StepVerifier.create(fruitsFlux)
                .expectNext("ORANGE", "BANANA")
                .verifyComplete();
    }

    @Test
    void fruitsFluxFlatMap() {
        var fruitsFlux = fluxAndMonoServices.fruitsFluxFlatMap();
        StepVerifier.create(fruitsFlux)
                .expectNextCount(17)
                .verifyComplete();
    }

    @Test
    void fruitsFluxFlatMapAsync() {
        var fruitsFlux = fluxAndMonoServices.fruitsFluxFlatMapAsync();
        StepVerifier.create(fruitsFlux)
                .expectNextCount(17)
                .verifyComplete();
    }

    @Test
    void fruitsFluxConcatMap() {
        var fruitsFlux = fluxAndMonoServices.fruitsFluxConcatMap();
        StepVerifier.create(fruitsFlux)
                .expectNextCount(17)
                .verifyComplete();
    }

    @Test
    void fruitsFluxTransform() {
        var fruitsFlux = fluxAndMonoServices.fruitsFluxTransform(5);
        StepVerifier.create(fruitsFlux)
                .expectNext("Orange", "Banana")
                .verifyComplete();
    }
}