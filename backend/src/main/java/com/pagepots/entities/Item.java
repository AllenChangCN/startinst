package com.pagepots.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * Tag用于描述Page
 */
@Entity
public class Item {

    /**
     * 页面ID
     */
    @Id
    @GeneratedValue
    private Long id;

    private Boolean valid;

    private String imgUrl;

}
