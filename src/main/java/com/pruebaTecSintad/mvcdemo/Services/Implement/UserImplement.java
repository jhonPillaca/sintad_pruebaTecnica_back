package com.pruebaTecSintad.mvcdemo.Services.Implement;

import com.pruebaTecSintad.mvcdemo.Model.User;
import com.pruebaTecSintad.mvcdemo.Repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserImplement implements UserDetailsService {

    private final UserRepository userRepository;

    public UserImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findOneByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException(String.format("User not exists &s", username));
        }

        List<GrantedAuthority> roles = new ArrayList<>();

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getEnabled(),
                true,
                true,
                true,
                roles
        );
        return userDetails;
    }
}
