package ru.sbrf.newsagregator.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import ru.sbrf.newsagregator.entity.newsapi.Article;
import ru.sbrf.newsagregator.entity.newsapi.ExampleNewsAPI;
import ru.sbrf.newsagregator.entity.nyt.Doc;
import ru.sbrf.newsagregator.entity.nyt.ExampleNYTAPI;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class NYTAPI implements NewsI{

    private ObjectMapper objectMapper;
    private List<NewsGeneral> resultListNews;
    private String urlAPI;
    private ExampleNYTAPI exampleNYTAPI;

    @Override
    public List<NewsGeneral> listNews(String interest) {
        objectMapper = new ObjectMapper();
        if (interest.isBlank()) {
            interest = "Moscow";
        }
        urlAPI = "http://api.nytimes.com/svc/search/v2/articlesearch.json?q=+" + interest + "&api-key=r1uB0G0wd2l54cwGdJSigE3Gl8pXGVK0";
        try {
            exampleNYTAPI = objectMapper.readValue(new URL(urlAPI), ExampleNYTAPI.class);
            resultListNews = new ArrayList<>();
            for(Doc i : exampleNYTAPI.getResponse().getDocs()) {
                resultListNews.add(new NewsGeneral( "https://static01.nyt.com/" + i.getMultimedia().get(0).getUrl(), i.getWebUrl(), i.getAbstract()));
            }
        } catch (Exception ex) {
            resultListNews = new ArrayList<>();
            log.info(ex.getMessage());
        }
        return resultListNews;
    }
}
