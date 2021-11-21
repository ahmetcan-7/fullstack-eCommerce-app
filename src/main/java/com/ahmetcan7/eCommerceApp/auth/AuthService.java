package com.ahmetcan7.eCommerceApp.auth;

import javax.transaction.Transactional;

import com.ahmetcan7.eCommerceApp.dto.UserDto;
import com.ahmetcan7.eCommerceApp.dto.UserDtoConverter;
import com.ahmetcan7.eCommerceApp.model.User;
import com.ahmetcan7.eCommerceApp.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;


@Service
public class AuthService {

    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    TokenRepository tokenRepository;

    UserDtoConverter userDtoConverter;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenRepository tokenRepository,
                       UserDtoConverter userDtoConverter) {
        super();
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenRepository = tokenRepository;
        this.userDtoConverter = userDtoConverter;
    }

    public AuthResponse authenticate(Credentials credentials) {
        User inDB = userRepository.findByUsername(credentials.getUsername());
        if(inDB == null) {
            throw new AuthException("Username or password is incorrect");
        }
        boolean matches = passwordEncoder.matches(credentials.getPassword(), inDB.getPassword());
        if(!matches) {
            throw new AuthException("Username or password is incorrect");
        }
        UserDto userDto = userDtoConverter.convert(inDB);
        String token = generateRandomToken();

        Token tokenEntity = new Token();
        tokenEntity.setToken(token);
        tokenEntity.setUser(inDB);
        tokenRepository.save(tokenEntity);
        AuthResponse response = new AuthResponse();
        response.setUser(userDto);
        response.setToken(token);
        return response;
    }

    @Transactional
    public UserDetails getUserDetails(String token) {
        Optional<Token> optionalToken = tokenRepository.findById(token);
        if(!optionalToken.isPresent()) {
            return null;
        }
        return optionalToken.get().getUser();
    }

    public String generateRandomToken() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public void clearToken(String token) {
        tokenRepository.deleteById(token);

    }

}

