package com.pagepots.entities;

import javax.persistence.*;

@Entity
public class Page {

    /**
     * 页面ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 页面名称
     */
    private String name;

    /**
     * 是否在首页展示及展示顺序；0不展示，1-10为顺序；不超过10
     */
    private Integer index;
}
