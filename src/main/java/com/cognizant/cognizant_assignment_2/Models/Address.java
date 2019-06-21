package com.cognizant.cognizant_assignment_2.Models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Accessors(chain = true)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String street;

    @Column(columnDefinition = "TEXT")
    private String suite;

    @Column(columnDefinition = "TEXT")
    private String city;

    @Column(columnDefinition = "TEXT")
    private String zipcode;
}
