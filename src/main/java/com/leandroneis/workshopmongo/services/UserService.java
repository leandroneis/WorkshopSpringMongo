package com.leandroneis.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import com.leandroneis.workshopmongo.dto.UserDTO;
import com.leandroneis.workshopmongo.services.exception.ObjectNotFoundException;
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

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj){
		return repo.insert(obj);
	}

	public User fromDTO(UserDTO objDto){
		return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
	}
}
