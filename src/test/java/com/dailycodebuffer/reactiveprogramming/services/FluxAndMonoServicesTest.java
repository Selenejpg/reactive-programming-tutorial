package com.dailycodebuffer.reactiveprogramming.services;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class FluxAndMonoServicesTest {

    FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();

    //TEST FLUX E MONO
    @Test
    void fruitsFlux() {
        var fruitsFlux = fluxAndMonoServices.fruitsFlux();
        StepVerifier.create(fruitsFlux)
                .expectNext("Mango", "Orange", "Banana")
                .verifyComplete();
    }

    @Test
    void fruitsMono() {
        var fruitsMono = fluxAndMonoServices.fruitsMono();
        StepVerifier.create(fruitsMono)
                .expectNext("Mango")
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
}