package com.craftable.ProofOfConcept.Repository;

import com.craftable.ProofOfConcept.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepoInterface extends JpaRepository<Book,Integer> {
}
