package icu.lyt0628.jzr_takeout.repo.mapper;


import icu.lyt0628.jzr_takeout.service.domain.impl.Consumer;
import org.apache.ibatis.annotations.Mapper;

/**
 * Mybatis cannot identify Mono and Flux, petty.
 */
@Mapper
public interface IUserMapper {
    void addUser(Consumer consumer);
    Consumer findConsumer(Long id);
    void updateConsumer(Consumer consumer);
}
