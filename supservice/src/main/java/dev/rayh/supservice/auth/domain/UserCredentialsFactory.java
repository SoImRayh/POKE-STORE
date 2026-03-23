package dev.rayh.supservice.auth.domain;

import java.util.HashSet;

public class UserCredentialsFactory {
    //todo implements
    public static UserCredentials modelFrom(UserCredentialsEntity entity){
        var model = new UserCredentials();

        model.setEmail(entity.getEmail());
        model.setPassword(entity.getPassword());
        model.setActive(entity.isActive());
        model.setRoles(entity.getRoles());
        return model;
    }

    public static UserCredentials modelFrom(NewAccountDto dto){
        UserCredentials credentials = new UserCredentials();

        credentials.setEmail(dto.email());
        credentials.setActive(false);
        credentials.setRoles(new HashSet<>());
        credentials.setPassword(dto.password());
        return credentials;
    }
    //todo implements
    public static UserCredentialsEntity entityFrom(UserCredentials model){
        UserCredentialsEntity entity = new UserCredentialsEntity();

        entity.setEmail(model.getEmail());
        entity.setPassword(model.getPassword());
        entity.setRoles(model.getRoles());
        entity.setActive(model.isActive());
        return entity;
    }
}
