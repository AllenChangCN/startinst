package com.pagepots.entities;


import javax.persistence.*;

@Entity
//@Table(indexes = {@Index(name = "pageid",columnList = "page_id",unique = false)})
public class Widget {

    /**
     * 页面ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 所属主页面ID
     */
    @OneToOne
    private Page page;

    /**
     * 排序
     */
    private Long sort;

    /**
     * Pot名称
     */
    private String title;

    /**
     * Widget Title
     */
    private String description;

    /**
     * Widget 的内容，JSON格式，方便在前端展示
     */
    private String content;
}
