package com.example.homework.repositories;

import com.example.homework.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByEmail(@Email @NotEmpty String email);
    User findByEmail(String email);
}
