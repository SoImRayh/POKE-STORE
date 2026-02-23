package dev.rayh.cardstore.domain.factory;

import org.springframework.beans.BeanUtils;

import dev.rayh.cardstore.domain.account.Client;
import dev.rayh.cardstore.entity.ClientEntity;

public class ClientFactory {

    public static ClientEntity toEntity(Client c){
        ClientEntity entity = new ClientEntity();

        BeanUtils.copyProperties(c, entity);

        return entity;
    }
}
