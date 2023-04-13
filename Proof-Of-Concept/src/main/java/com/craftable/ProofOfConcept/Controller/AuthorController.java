package com.craftable.ProofOfConcept.Controller;

import com.craftable.ProofOfConcept.Model.Author;
import com.craftable.ProofOfConcept.Repository.AuthorRepoInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
@Slf4j
public class AuthorController {
    @Autowired
    AuthorRepoInterface authorRepo;
    @GetMapping("/")
    public ResponseEntity<?> findAllAuthors(){
        return ResponseEntity.ok().body(authorRepo.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>findAuthorById(@PathVariable int id){
        return ResponseEntity.ok().body(authorRepo.findById(id));
    }
    @PostMapping("/")
    public ResponseEntity<?> addAuthor(Author author){
        return ResponseEntity.status(HttpStatus.CREATED).body(authorRepo.save(author));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthor (@PathVariable int id,@RequestBody Author author ){
        return ResponseEntity.status(HttpStatus.OK).body(authorRepo.save(author));
    }
    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable int id){
        authorRepo.delete(authorRepo.findById(id).get());
    }
}
