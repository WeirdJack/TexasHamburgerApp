package com.bhargav.texashamco.repository.security;

import com.bhargav.texashamco.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuthRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String userName);
}
