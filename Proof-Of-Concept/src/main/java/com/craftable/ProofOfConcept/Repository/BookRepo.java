package com.craftable.ProofOfConcept.Repository;

import com.craftable.ProofOfConcept.Model.Book;
import com.craftable.ProofOfConcept.Util.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookRepo {
    private List<Book> books;

    public BookRepo() {
        this.books = new ArrayList<>(Data.loadBooks());
    }

    public List<Book> findAll() {
        return books;
    }
    public Book findById(String title){
        return books.stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst().orElse(null);
    }
    public Book save(String title, Book book){
        boolean isPresent = false;
        for(int i=0; i<books.size();i++){
            if(books.get(i).getTitle().equals(title)){
                books.set(i,book);
                isPresent=true;
                break;
            }
        }
        if(!isPresent) books.add(book);
        return book;
    }
    public Book save(Book book){
        return save(book.getTitle(),book);
    }

    public void delete(String title){
        books.stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst().ifPresent(book -> books.remove(book));
    }

}
