package ru.sbrf.newsagregator.entity.newsapi;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ExampleNewsAPI {

    private String status;
    private Integer totalResults;
    private List<Article> articles = null;
}
