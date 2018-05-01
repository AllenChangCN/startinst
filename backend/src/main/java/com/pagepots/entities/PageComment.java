package com.pagepots.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * 评论
 *
 * @author liuyuancheng
 */
@Entity
@Table(name = "page_comments")
public class PageComment {

    /**
     * 页面ID
     */
    @Id
    @GeneratedValue
    private Long id;

}
