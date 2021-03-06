package ru.sbrf.newsagregator.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import ru.sbrf.newsagregator.entity.News;
import ru.sbrf.newsagregator.entity.newsapi.Article;
import ru.sbrf.newsagregator.entity.newsapi.ExampleNewsAPI;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class APINews implements INews {

    private ObjectMapper objectMapper;
    private List<News> resultListNews;
    private String urlAPI;
    private ExampleNewsAPI exampleNewsAPI;

    @Override
    public List<News> listNews(String interest) {
        objectMapper = new ObjectMapper();
        if (interest.isBlank()) {
            interest = "News";
        }
        urlAPI = "http://newsapi.org/v2/everything?q=" + interest + "&sortBy=publishedAt&apiKey=cbe78b68f59e464fbecf654bc8610f76";
        try {
            exampleNewsAPI = objectMapper.readValue(new URL(urlAPI), ExampleNewsAPI.class);
            resultListNews = new ArrayList<>();
            for (Article i : exampleNewsAPI.getArticles()) {
                resultListNews.add(new News(i.getUrlToImage(), i.getUrl(), i.getTitle()));
            }
        } catch (Exception ex) {
            resultListNews = new ArrayList<>();
            log.info(ex.getMessage());
        }
        return resultListNews;
    }
}
