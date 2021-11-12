package com.leandroneis.workshopmongo.services;

import com.leandroneis.workshopmongo.domain.Post;
import com.leandroneis.workshopmongo.domain.User;
import com.leandroneis.workshopmongo.dto.UserDTO;
import com.leandroneis.workshopmongo.repository.PostRepository;
import com.leandroneis.workshopmongo.repository.UserRepository;
import com.leandroneis.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repo;

    public List<Post> findAll(){
        return repo.findAll();
    }

//    public User findById(String id) {
//        Optional<User> obj = repo.findById(id);
//        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
//    }
//
//    public User insert(User obj){
//        return repo.insert(obj);
//    }
//
//    public void delete(String id){
//        findById(id);
//        repo.deleteById(id);
//    }
//    public User update(User obj) {
//        User newObj = findById(obj.getId());
//        updateData(newObj, obj);
//        return repo.save(newObj);
//    }
//
//    private void updateData(User newObj, User obj) {
//        newObj.setName(obj.getName());
//        newObj.setEmail(obj.getEmail());
//    }
//
//
//    public User fromDTO(UserDTO objDto){
//        return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
//    }
}