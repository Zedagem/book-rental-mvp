package com.craftable.ProofOfConcept.Repository;

import com.craftable.ProofOfConcept.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepoInterface extends JpaRepository<Author,Integer> {
}
