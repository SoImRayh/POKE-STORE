package dev.rayh.supservice.auth.service.impl;

import dev.rayh.supservice.auth.exception.LoginRequestException;
import dev.rayh.supservice.auth.repo.UserCredentialsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserCredentialsRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var usercredential = repository.findByEmail(username).orElseThrow(
                () -> new LoginRequestException("user not found!")
        );


        return new User(
                usercredential.getEmail(), usercredential.getPassword(),
                usercredential.getRoles().stream().map(role ->  new SimpleGrantedAuthority(role.name())).toList()
        );
    }
}
