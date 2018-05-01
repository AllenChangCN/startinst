package com.pagepots.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 评论
 *
 * @author liuyuancheng
 */
@Entity
@Table(name = "sites")
public class Site {

    /**
     * 页面ID
     */
    @Id
    @GeneratedValue
    private Long id;

    private String domain;

    private String title;

    private String description;





}
