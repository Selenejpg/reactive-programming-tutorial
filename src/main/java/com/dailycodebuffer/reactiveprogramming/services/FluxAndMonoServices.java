package com.dailycodebuffer.reactiveprogramming.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoServices {

    public static void main(String[] args) {
        FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();
        fluxAndMonoServices.fruitsFlux().subscribe(s -> System.out.println("s = " + s));
        fluxAndMonoServices.fruitsMono().subscribe(s -> System.out.println("Mono s = " + s));
    }

    //OPERATORI
    public Flux<String> fruitsFluxMap() {
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                .map(String::toUpperCase)
                .log();
    }

    public Flux<String> fruitsFluxFilter(int number) {
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                .filter(s -> s.length() > number)
                .log();
    }

    public Flux<String> fruitsFluxMapFilter(int number) {
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                .map(String::toUpperCase)
                .filter(s -> s.length() > number)
                .log();
    }

    //FLUX E MONO
    public Flux<String> fruitsFlux() {
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana")).log();
    }

    public Mono<String> fruitsMono() {
        return Mono.just("Mango").log();
    }
}
