package com.dailycodebuffer.reactiveprogramming.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class FluxAndMonoServices {

    public static void main(String[] args) {
        FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();
        fluxAndMonoServices.fruitsFlux().subscribe(s -> System.out.println("s = " + s));
        fluxAndMonoServices.fruitsMono().subscribe(s -> System.out.println("Mono s = " + s));
    }

    //FLUX
    public Flux<String> fruitsFlux() {
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana")).log();
    }

    //MONO
    public Mono<String> fruitsMono() {
        return Mono.just("Mango").log();
    }

    public Mono<List<String>> fruitsMonoFlatMap() {
        return Mono.just("Mango")
                .flatMap(s -> Mono.just(List.of(s.split(""))))
                .log();
    }

    public Flux<String> fruitsMonoFlatMapMany() {
        return Mono.just("Mango")
                .flatMapMany(s -> Flux.just(s.split("")))
                .log();
    }

    //OPERATORI

    public Flux<String> fruitsFluxFilter(int number) {
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                .filter(s -> s.length() > number)
                .log();
    }

    public Flux<String> fruitsFluxMap() {
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                .map(String::toUpperCase)
                .log();
    }

    public Flux<String> fruitsFluxFlatMapAsync(){
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                .flatMap(s -> Flux.just(s.split("")))
                .delayElements(Duration.ofMillis(
                        new Random().nextInt(1000)
                ))
                .log();
    }

    public Flux<String> fruitsFluxMapFilter(int number) {
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                .map(String::toUpperCase)
                .filter(s -> s.length() > number)
                .log();
    }

    public Flux<String> fruitsFluxFlatMap(){
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                .flatMap(s -> Flux.just(s.split("")))
                .log();
    }

    public Flux<String> fruitsFluxConcatMap(){
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                .concatMap(s -> Flux.just(s.split("")))
                .delayElements(Duration.ofMillis(
                        new Random().nextInt(1000)
                ))
                .log();
    }

    public Flux<String> fruitsFluxTransform(int number) {
        Function<Flux<String>, Flux<String>> filterData = data -> data.filter(s -> s.length() > number);
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                .transform(filterData)
                .log();
    }
}
