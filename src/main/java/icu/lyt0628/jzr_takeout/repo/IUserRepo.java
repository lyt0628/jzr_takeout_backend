package icu.lyt0628.jzr_takeout.repo;


import icu.lyt0628.jzr_takeout.service.domain.impl.Consumer;
import reactor.core.publisher.Mono;

public interface IUserRepo {
    void addConsumer(Consumer consumer);
    Mono<Consumer> findConsumer(Long id);
    void markUserLogOff(Long id);
}