package dev.rayh.cardstore.service.imp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dev.rayh.cardstore.domain.account.Client;
import dev.rayh.cardstore.domain.factory.ClientFactory;
import dev.rayh.cardstore.service.ClientService;

@Service
public class ClientServiceImp implements ClientService {

    @Override
    public ResponseEntity createOne(Client c) {
        if (c.normalize()){
            return new ResponseEntity<>(c , HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        // TODO Auto-generated method stub

    }

}
