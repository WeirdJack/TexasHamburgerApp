package com.bhargav.texashamco.service.security;

import com.bhargav.texashamco.models.User;
import com.bhargav.texashamco.repository.security.UserAuthRepository;
import com.bhargav.texashamco.security.UserAuthDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthService implements UserDetailsService {

    @Autowired
    UserAuthRepository userAuthRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> user = userAuthRepository.findByUserName(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("Not Found: " + userName));

        return user.map(UserAuthDetails::new).get();
    }
}
