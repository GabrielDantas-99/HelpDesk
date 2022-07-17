package com.gabriel.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gabriel.api.domain.Pessoa;
import com.gabriel.api.repositories.PessoaRepository;
import com.gabriel.api.security.UserSS;

@Service
public class UserDetailsServiceImlp implements UserDetailsService {

    @Autowired
    private PessoaRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Pessoa> user = repository.findByEmail(email);
        if (user.isPresent()) {
            return new UserSS(
                user.get().getId(), 
                user.get().getEmail(), 
                user.get().getSenha(), 
                user.get().getPerfis()
            );
        } 
        throw new UsernameNotFoundException(email);
    }
    
}
