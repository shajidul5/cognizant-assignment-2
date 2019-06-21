package com.cognizant.cognizant_assignment_2.Models;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Accessors(chain = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String name;

    @Column(columnDefinition = "TEXT")
    private String username;

    @Column(columnDefinition = "TEXT")
    private String email;

    @Column(columnDefinition = "TEXT")
    private String phone;

    @Column(columnDefinition = "TEXT")
    private String website;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "user")
    private Company company;
}
