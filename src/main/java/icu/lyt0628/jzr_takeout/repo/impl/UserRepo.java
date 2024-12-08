package icu.lyt0628.jzr_takeout.repo.impl;

import icu.lyt0628.jzr_takeout.common.RecordConstants;
import icu.lyt0628.jzr_takeout.repo.IUserRepo;
import icu.lyt0628.jzr_takeout.repo.mapper.IUserMapper;
import icu.lyt0628.jzr_takeout.service.domain.impl.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class UserRepo implements IUserRepo {
    @Autowired
    IUserMapper userMapper;

    @Override
    public void addConsumer(Consumer consumer) {
        consumer.setType(RecordConstants.USER_CONSUMER);
        userMapper.addUser(consumer);
    }

    @Override
    public Mono<Consumer> findConsumer(Long id) {
        var c = userMapper.findConsumer(id);

        return Mono.just(c);
    }

    @Override
    public void markUserLogOff(Long id) {
        var c = Consumer.builder()
                .id(id)
                .status(RecordConstants.INVALID_STATUS)
                .build();
        userMapper.updateConsumer(c);

    }
}
