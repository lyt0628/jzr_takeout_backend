package icu.lyt0628.jzr_takeout.service.domain.impl;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;




@Data
@NoArgsConstructor
@SuperBuilder
public abstract class User {
    Long id;
    String username;
    String pwd;
    String phone;

    Date createdAt;
    Date updatedAt;
    Integer status;

    String type;
}
