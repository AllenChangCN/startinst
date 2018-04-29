package com.pagepots.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Tag用于描述Page
 */
@Entity
public class Tag {

    /**
     * 页面ID
     */
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "tags")
    private Set<Page> pages;

}
