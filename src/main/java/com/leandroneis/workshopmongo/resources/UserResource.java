package com.leandroneis.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.leandroneis.workshopmongo.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.leandroneis.workshopmongo.domain.User;
import com.leandroneis.workshopmongo.dto.UserDTO;
import com.leandroneis.workshopmongo.services.UserService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	// Outra maneira de mapear @GetMapping
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}

	//Outra alternativa @PostMapping
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(("/{id}")).buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	//Outra alternativa @PostMapping
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UserDTO objDto,@PathVariable String id) {
		User obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value="/{id}/posts", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getPosts());
	}


}
