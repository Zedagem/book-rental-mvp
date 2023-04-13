package com.craftable.ProofOfConcept.Controller;

import com.craftable.ProofOfConcept.Model.Book;
import com.craftable.ProofOfConcept.Repository.BookRepoInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {
    @Autowired
    BookRepoInterface bookRepo;

    @GetMapping({"/", ""})
    public ResponseEntity<?> findAllBooks(){
        return ResponseEntity.ok().body(bookRepo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findBookById(@PathVariable int id){
        return ResponseEntity.ok().body(bookRepo.findById(id));
    }
    @PostMapping("/")
    public ResponseEntity<?> addBook(@RequestBody Book book){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookRepo.save(book));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable int id, @RequestBody Book book){

        return ResponseEntity.status(HttpStatus.OK).body(bookRepo.save(book));
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id){
        bookRepo.delete(bookRepo.findById(id).get());
    }

}
