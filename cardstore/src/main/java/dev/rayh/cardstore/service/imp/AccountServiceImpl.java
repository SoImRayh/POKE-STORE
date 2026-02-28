package dev.rayh.cardstore.service.imp;

import dev.rayh.cardstore.domain.account.Account;
import dev.rayh.cardstore.domain.account.AccountRole;
import dev.rayh.cardstore.domain.dto.NewAccountDto;
import dev.rayh.cardstore.domain.factory.AccountFactory;
import dev.rayh.cardstore.entity.AccountEntity;
import dev.rayh.cardstore.exception.NewAccountException;
import dev.rayh.cardstore.exception.NoRecordFoundexception;
import dev.rayh.cardstore.repository.AccountRepository;
import dev.rayh.cardstore.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    @Transactional
    @Override
    public ResponseEntity createNewAccount(NewAccountDto dto) {
        Account model;

        //verifying if email already exists in database
        if (repository.existsByEmail(dto.email()))
            throw new NewAccountException("this email already exists");

        //verifying if passwords matches
        if ( !dto.password().equals(dto.confirmPassword()) )
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        model = AccountFactory.toModel(dto);
        //setting as default account and save in database
        try {
            model.setCreatedAt(LocalDateTime.now());
            model.setId(UUID.randomUUID());;
            model.setRole(AccountRole.USER);
            model.setIsActive(false);
            //hashing and updating the password
            //TODO implement hashing here

            repository.save(AccountFactory.toEntity(model));

            return new ResponseEntity(model, HttpStatus.OK);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity deleteAccount(UUID id) {

        AccountEntity account = repository.findById(id)
                .orElseThrow( () -> new NoRecordFoundexception("No record Found"));

        account.setIsActive(false);

        repository.save(account);

        return new ResponseEntity("Conta deletada com sucesso", HttpStatus.OK);
    }

    @Override
    public ResponseEntity updateAccount(UUID id, Account account) {
        Account model;

        model = AccountFactory.toModel(findById(id));






        return null;
    }

    private AccountEntity findById(UUID id){
        return repository.findById(id).orElseThrow( () -> new NoRecordFoundexception("No Account record found"));
    }
}
