package dev.rayh.cardstore.domain.factory;

import dev.rayh.cardstore.domain.account.Account;
import dev.rayh.cardstore.domain.dto.NewAccountDto;
import dev.rayh.cardstore.domain.dto.NewClientDto;
import dev.rayh.cardstore.entity.AccountEntity;
import org.springframework.beans.BeanUtils;

public class AccountFactory {

    public static AccountEntity toEntity(Account model){
        AccountEntity entity = new AccountEntity();

        BeanUtils.copyProperties(model, entity);

        return entity;
    }

    public static Account toModel(AccountEntity entity){
        Account model = new Account();

        BeanUtils.copyProperties(entity, model);
        return model;
    }

    public static Account toModel(NewAccountDto dto) {
        var model = new Account();

        BeanUtils.copyProperties(dto, model);


        return model;
    }
}
