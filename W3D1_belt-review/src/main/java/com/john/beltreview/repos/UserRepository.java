package com.john.beltreview.repos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.john.beltreview.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	Optional<User> findByEmail(String email);
}
