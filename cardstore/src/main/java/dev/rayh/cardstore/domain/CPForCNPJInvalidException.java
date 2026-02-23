package dev.rayh.cardstore.domain;

import dev.rayh.cardstore.domain.account.Client;
import lombok.Generated;
import lombok.Getter;

@Getter
public class CPForCNPJInvalidException extends RuntimeException {
    private static final String MESSAGE = "CPF or Cnpj invalid";

    private Client client;

    public CPForCNPJInvalidException (Client c){
        super(MESSAGE);
        this.client = c;
    }

    public CPForCNPJInvalidException (String message, Client c){
        super(message);
        this.client = c;
    }
}
