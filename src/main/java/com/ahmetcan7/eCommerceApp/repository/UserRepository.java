package com.ahmetcan7.eCommerceApp.repository;

import com.ahmetcan7.eCommerceApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByUsername(String username);
    User findByUsername(String username);
}
