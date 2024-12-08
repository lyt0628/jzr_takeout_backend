package icu.lyt0628.jzr_takeout.api;


import icu.lyt0628.jzr_takeout.api.dto.ServerResponse;
import icu.lyt0628.jzr_takeout.repo.IUserRepo;
import icu.lyt0628.jzr_takeout.service.domain.impl.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    IUserRepo consumerRepo;

    @PostMapping
    public ServerResponse<Object> addConsumer(@RequestBody Consumer c) {
        consumerRepo.addConsumer(c);
        return ServerResponse.success();
    }

    @GetMapping("/{id}")
    public  Mono<ServerResponse<Consumer>> findConsumer(@PathVariable Long id){
        var mono = consumerRepo.findConsumer(id);
        mono.subscribe(consumer -> log.info(consumer.toString()));
        return mono.map(ServerResponse::success);
    }

    @PostMapping("/{id}/logoff")
    public ServerResponse<Object> addConsumer(@PathVariable Long id) {
        consumerRepo.markUserLogOff(id);
        return ServerResponse.success();
    }

}
