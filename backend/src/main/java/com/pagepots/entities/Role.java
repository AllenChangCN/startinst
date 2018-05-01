package com.pagepots.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Enumerated {@link User} roles.
 *
 * @author vladimir.stankovic
 *
 * Aug 16, 2016
 */
@Entity
@Table(name = "roles")

public class Role {

    @GeneratedValue
    @Id
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "roles",targetEntity = User.class)
    private List<User> users = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}