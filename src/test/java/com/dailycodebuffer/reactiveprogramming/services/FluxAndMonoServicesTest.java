package com.dailycodebuffer.reactiveprogramming.services;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class FluxAndMonoServicesTest {

    FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();

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

    @Test
    void fruitsFluxMap() {
        var fruitsFlux = fluxAndMonoServices.fruitsFluxMap();
        StepVerifier.create(fruitsFlux)
                .expectNext("MANGO", "ORANGE", "BANANA")
                .verifyComplete();
    }
}