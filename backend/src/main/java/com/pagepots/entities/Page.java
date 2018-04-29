package com.pagepots.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Page {

    /**
     * 页面ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 用户ID
     */
    @OneToOne
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<Tag> tags;

    /**
     * 页面名称
     */
    private String name;

    /**
     * 是否在首页展示及展示顺序；0不展示，1-10为顺序；不超过10
     */
    private Long sort;

    private Boolean shared;
}
