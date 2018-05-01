package com.pagepots.entities;

import javax.persistence.*;

@Entity
@Table(name = "page_favorites")

public class PageFavorite {

    /**
     * 页面ID
     */
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Page page;
}
