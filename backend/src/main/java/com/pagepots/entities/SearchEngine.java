package com.pagepots.entities;

import javax.persistence.*;

@Entity
public class SearchEngine {

    /**
     * 页面ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String name;

    private String url;

    private String logoUrl;
}
