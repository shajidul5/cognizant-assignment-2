package com.cognizant.cognizant_assignment_2.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Accessors(chain = true)
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String name;

    @Column(columnDefinition = "TEXT")
    private String catchphrase;

    @Column(columnDefinition = "TEXT")
    private String bs;

    @OneToOne
    @JoinColumn(name = "id")
    @JsonBackReference
    private User user;
}
