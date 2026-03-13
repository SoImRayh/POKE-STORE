package dev.rayh.cardstore.exception;

import dev.rayh.cardstore.domain.account.Client;
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
