package com.craftable.ProofOfConcept.Repository;

import com.craftable.ProofOfConcept.Model.Author;
import com.craftable.ProofOfConcept.Util.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorRepo {

    private List<Author> authorList;

   public AuthorRepo(){
        this.authorList = new ArrayList<>(Data.loadAuthors());
    }

    public List<Author> findAll() {
        return authorList;
    }
    public Author findById(String fName){
        return authorList.stream()
                .filter(author -> author.getFirstName().equals(fName))
                .findFirst().orElse(null);
    }
    public Author save(String fName, Author author){
        boolean isPresent = false;
        for(int i=0; i<authorList.size();i++){
            if(authorList.get(i).getFirstName().equals(fName)){
                authorList.set(i,author);
                isPresent=true;
                break;
            }
        }
        if(!isPresent) authorList.add(author);
        return author;
    }
    public Author save(Author author){
        return save(author.getFirstName(),author);
    }

    public void delete(String fName){
        authorList.stream()
                .filter(author -> author.getFirstName().equals(fName))
                .findFirst().ifPresent(author -> authorList.remove(author));
    }

}
