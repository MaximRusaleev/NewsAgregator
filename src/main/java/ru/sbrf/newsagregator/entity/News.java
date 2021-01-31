package ru.sbrf.newsagregator.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class News {

    private String urlToImage;
    private String url;
    private String title;

}
