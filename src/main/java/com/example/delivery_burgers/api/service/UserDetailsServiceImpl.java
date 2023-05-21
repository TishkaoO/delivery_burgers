package com.example.delivery_burgers.api.service;

import com.example.delivery_burgers.store.entity.CustomerEntity;
import com.example.delivery_burgers.store.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final CustomerRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomerEntity customer = userRepository.findByUsername(username);
        if (customer == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(customer.getUsername(), customer.getPassword(), emptyList());
    }
}
