package ru.sbrf.newsagregator.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class Blog {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String text;
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private String filename;

    public Blog(){
    }

    public Blog(String text, String tag/*, User user*/) {
        this.text = text;
        this.tag = tag;
        //this.author = user;
    }
}
