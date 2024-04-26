package com.john.loginreg.repos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.john.loginreg.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	Optional<User> findByEmail(String email);
}
