package com.leandroneis.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.leandroneis.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
