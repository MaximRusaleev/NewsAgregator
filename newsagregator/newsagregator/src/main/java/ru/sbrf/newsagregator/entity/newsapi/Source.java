package ru.sbrf.newsagregator.entity.newsapi;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Source {

    private String id;
    private String name;
    //private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
