package com.ahmetcan7.eCommerceApp.configuration;

import com.ahmetcan7.eCommerceApp.model.User;
import com.ahmetcan7.eCommerceApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAuthService implements UserDetailsService{

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User inDB = userRepository.findByUsername(username);
        if(inDB == null)
            throw new UsernameNotFoundException("User not found");
        return inDB;
    }

}