package com.javateam.SpringBootNaverOAuth.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.javateam.SpringBootNaverOAuth.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    
}
