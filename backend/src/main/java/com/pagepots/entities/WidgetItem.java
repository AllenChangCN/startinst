package com.pagepots.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Tag用于描述Page
 */
@Entity
@Table(name = "widget_items")
public class WidgetItem {

    /**
     * 页面ID
     */
    @Id
    @GeneratedValue
    private Long id;

    private Boolean valid;

    private String imgUrl;

    /**
     * 对应的网站Id
     */
    private Site siteId;

}
