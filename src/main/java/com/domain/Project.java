package com.domain;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor //to add @RequiredArgsConstructor
public class Project {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;


    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
