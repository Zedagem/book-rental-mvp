package com.craftable.ProofOfConcept.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private String title;
    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(name = "bookId")
    private List<Author> authorList;
    private String ISBN;
    private Date publishedDate;


}
