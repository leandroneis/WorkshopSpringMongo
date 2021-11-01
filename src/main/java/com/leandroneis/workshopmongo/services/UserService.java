package com.leandroneis.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandroneis.workshopmongo.domain.User;
import com.leandroneis.workshopmongo.repository.UseRrepository;

@Service
public class UserService {
	
	@Autowired
	private UseRrepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}

}
