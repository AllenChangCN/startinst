package com.pagepots.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Comment {

    /**
     * 页面ID
     */
    @Id
    @GeneratedValue
    private Long id;

}
