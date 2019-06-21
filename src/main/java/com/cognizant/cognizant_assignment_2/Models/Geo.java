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
public class Geo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String lat;

    @Column(columnDefinition = "TEXT")
    private String lng;

    @OneToOne
    @JoinColumn(name = "id")
    @JsonBackReference
    private Address address;
}
