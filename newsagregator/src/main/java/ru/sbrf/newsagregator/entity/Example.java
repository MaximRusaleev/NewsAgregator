package ru.sbrf.newsagregator.entity;

import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Example {

    private String status;
    private Integer totalResults;
    private List<Article> articles = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
