package com.craftable.ProofOfConcept.Util;

import com.craftable.ProofOfConcept.Model.Author;
import com.craftable.ProofOfConcept.Model.Book;

import java.util.Date;
import java.util.List;

public class Data {
    public static List<Book> loadBooks(){
        Book book1 = new Book(1,"Java",List.of(loadAuthors().get(0),loadAuthors().get(1)),"234343",new Date());
        Book book2 = new Book(2,"Node",List.of(loadAuthors().get(2),loadAuthors().get(3)),"4354534",new Date());
        Book book3 = new Book(3,"Ember",List.of(loadAuthors().get(1),loadAuthors().get(3),loadAuthors().get(0)),"78234",new Date());

        return List.of(book1,book2,book3);
    }

    public static List<Author> loadAuthors(){
        Author author1 = new Author(1,"John","Brown",new Date());
        Author author2 = new Author(2,"Bob","King",new Date());
        Author author3 = new Author(3,"James","Brown",new Date());
        Author author4 = new Author(4,"Luke","White",new Date());

        return List.of(author1,author2,author3,author4);
    }
}
