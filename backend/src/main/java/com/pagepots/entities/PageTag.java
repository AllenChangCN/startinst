package com.pagepots.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Tag用于描述Page
 * @author liuyuancheng
 */
@Entity
@Table(name = "page_tags")

public class PageTag {

    /**
     * 页面ID
     */
    @Id
    @GeneratedValue
    private Long id;

//    @ManyToMany(mappedBy = "page_tags")
//    private Set<Page> pages;

}
