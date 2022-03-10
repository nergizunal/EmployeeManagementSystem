package com.self.EMS.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "email")
    private String email;
}
