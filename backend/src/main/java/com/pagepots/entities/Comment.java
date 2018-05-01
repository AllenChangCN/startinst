package com.pagepots.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * 评论
 *
 * @author liuyuancheng
 */
@Entity
@Table(name = "comments")
public class Comment {

    /**
     * 页面ID
     */
    @Id
    @GeneratedValue
    private Long id;

}
