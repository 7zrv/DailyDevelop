package com.yoon.dailydevelop.domain.user.repository;

import com.yoon.dailydevelop.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean findByEmail(String email);

}
