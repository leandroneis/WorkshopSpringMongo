package com.leandroneis.workshopmongo.resources;

import com.leandroneis.workshopmongo.domain.Post;
import com.leandroneis.workshopmongo.dto.PostDTO;
import com.leandroneis.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

//    // Outra maneira de mapear @GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PostDTO>> findAll() {
        List<Post> list = service.findAll();
        List<PostDTO> listDTO = list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

//    @RequestMapping(value="/{id}", method = RequestMethod.GET)
//    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
//        User obj = service.findById(id);
//        return ResponseEntity.ok().body(new UserDTO(obj));
//    }
//
//    //Outra alternativa @PostMapping
//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
//        User obj = service.fromDTO(objDto);
//        obj = service.insert(obj);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(("/{id}")).buildAndExpand(obj.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }
//    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<Void> delete(@PathVariable String id) {
//        service.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    //Outra alternativa @PostMapping
//    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
//    public ResponseEntity<Void> update(@RequestBody UserDTO objDto,@PathVariable String id) {
//        User obj = service.fromDTO(objDto);
//        obj.setId(id);
//        obj = service.update(obj);
//        return ResponseEntity.noContent().build();
//    }
}
