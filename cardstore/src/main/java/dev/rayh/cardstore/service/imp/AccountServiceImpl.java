package dev.rayh.cardstore.service.imp;

import dev.rayh.cardstore.domain.account.Account;
import dev.rayh.cardstore.domain.account.AccountRole;
import dev.rayh.cardstore.domain.dto.Message;
import dev.rayh.cardstore.domain.dto.NewAccountDto;
import dev.rayh.cardstore.domain.factory.AccountFactory;
import dev.rayh.cardstore.entity.AccountEntity;
import dev.rayh.cardstore.exception.NewAccountException;
import dev.rayh.cardstore.exception.NoRecordFoundexception;
import dev.rayh.cardstore.integrations.kafka.KafkaService;
import dev.rayh.cardstore.integrations.redis.impl.RedisServiceImp;
import dev.rayh.cardstore.repository.AccountRepository;
import dev.rayh.cardstore.service.AccountService;
import dev.rayh.contracts.EmailEvent;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
//    @Value("${SPRING_MAIL_HOST}")
    private String MAIL_URL_BASE;

    private final AccountRepository repository;
    private final RedisServiceImp redisServiceImp;
    private final KafkaService<EmailEvent> kafkaService;

    @Transactional
    @Override
    public ResponseEntity createNewAccount(NewAccountDto dto) {
        final String FROM_EMAIL = "raykah.silva@gmail.com";
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
            model.setDefaultAccount();
            //hashing and updating the password
            //TODO implement hashing here

            repository.save(AccountFactory.toEntity(model));

            sendEmail(model.getEmail());


            return new ResponseEntity(HttpStatus.OK);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity deleteAccount(String email) {

        AccountEntity account = repository.findByEmail(email)
                .orElseThrow( () -> new NoRecordFoundexception("No record Found"));

        account.setIsActive(false);

        repository.delete(account);

        return new ResponseEntity(
                new Message("record deleted successfully"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity updateAccount(UUID id, Account account) {
        Account model;

        model = AccountFactory.toModel(findById(id));






        return null;
    }

    @Override
    public ResponseEntity verifyAndActivateAccount( String requestId) {
        AccountEntity accountEntity;

        String email = redisServiceImp.validateToken(requestId);

        accountEntity = repository.findByEmail(email).orElseThrow( () ->
                new NoRecordFoundexception("Email não registrado no sistema")
        );

        if (!accountEntity.getIsActive()){
            accountEntity.setIsActive(true);
        }else {
            return new ResponseEntity(
                    new Message("Account already activated"), HttpStatus.CONFLICT);
        }

        repository.save(accountEntity);

        return new ResponseEntity<>(
                new Message("Account activated"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity sendEmailOfVerification(NewAccountDto data) {
        AccountEntity entity;

        entity = repository.findByEmail(data.email()).orElseThrow(
                () -> new NoRecordFoundexception("Record not found in database")
        );

        if (!entity.getIsActive()){
            sendEmail(data.email());
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    private AccountEntity findById(UUID id){
        return repository.findById(id).orElseThrow( () -> new NoRecordFoundexception("No Account record found"));
    }

    private void sendEmail(String emailTo){
        // save in redis and post new event in kafka

        UUID id = redisServiceImp.saveToken(emailTo);

        String url = String.format("http://localhost:8081/api/account/verify?verificationID=%s", id);

        EmailEvent event = new EmailEvent("raykah.silva@gmail.com",
                "raykah.silva@gmail.com",
                emailTo,
                "EMAIL VERIFICATION",
                url);


        kafkaService.postMessage("email", event);


    }
}
