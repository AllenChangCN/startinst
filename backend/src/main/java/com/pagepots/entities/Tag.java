package com.pagepots.entities;

import javax.persistence.*;

/**
 * Tag用于描述Page
 */
@Entity
public class Tag {

    /**
     * 页面ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
