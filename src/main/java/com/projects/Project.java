package com.projects;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Entity
@Table(name = "projects")
@Getter @Setter @NoArgsConstructor
public class Project extends RepresentationModel<Project> {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Setter(AccessLevel.NONE)
    private Integer id;

    private String name;
    private String description;

    protected Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
