package ru.sbrf.newsagregator.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import ru.sbrf.newsagregator.entity.newsapi.Article;
import ru.sbrf.newsagregator.entity.newsapi.ExampleNewsAPI;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class NewsAPI implements NewsI {

    private ObjectMapper objectMapper;
    private List<NewsGeneral> resultListNews;
    private String urlAPI;
    private ExampleNewsAPI exampleNewsAPI;

    @Override
    public List<NewsGeneral> listNews(String interest) {
        objectMapper = new ObjectMapper();
        if (interest.isBlank()) {
            interest = "Moscow";
        }
        urlAPI = "http://newsapi.org/v2/everything?q=" + interest + "&sortBy=publishedAt&apiKey=cbe78b68f59e464fbecf654bc8610f76";
        try {
            exampleNewsAPI = objectMapper.readValue(new URL(urlAPI), ExampleNewsAPI.class);
            resultListNews = new ArrayList<>();
            for(Article i : exampleNewsAPI.getArticles()) {
                resultListNews.add(new NewsGeneral(i.getUrlToImage(), i.getUrl(), i.getTitle()));
            }
        } catch (Exception ex) {
            resultListNews = new ArrayList<>();
            log.info(ex.getMessage());
        }
        return resultListNews;
    }
}
