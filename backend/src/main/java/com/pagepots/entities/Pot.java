package com.pagepots.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pot {

    /**
     * 页面ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 所属主页面ID
     */
    private Long pageId;

    /**
     * Pot名称
     */
    private String name;

    /**
     * Pot描述
     */
    private String desc;

    /**
     * Pot 的内容，JSON格式，方便在前端展示
     */
    private String content;
}
