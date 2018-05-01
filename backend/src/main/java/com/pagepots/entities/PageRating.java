package com.pagepots.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Page的评分
 * @author liuyuancheng
 */
@Entity
@Table(name = "page_ratings")

public class PageRating {

    /**
     * 页面ID
     */
    @Id
    @GeneratedValue
    private Long id;

    private Boolean valid;

    private String imgUrl;

}
