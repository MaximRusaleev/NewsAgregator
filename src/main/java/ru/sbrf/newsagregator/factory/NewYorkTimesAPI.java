package ru.sbrf.newsagregator.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import ru.sbrf.newsagregator.entity.News;
import ru.sbrf.newsagregator.entity.newyorktimesapi.Doc;
import ru.sbrf.newsagregator.entity.newyorktimesapi.ExampleNYTAPI;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class NewYorkTimesAPI implements INews {

    private ObjectMapper objectMapper;
    private List<News> resultListNews;
    private String urlAPI;
    private ExampleNYTAPI exampleNYTAPI;

    @Override
    public List<News> listNews(String interest) {
        objectMapper = new ObjectMapper();
        if (interest.isBlank()) {
            interest = "News";
        }
        urlAPI = "http://api.nytimes.com/svc/search/v2/articlesearch.json?q=+" + interest + "&api-key=r1uB0G0wd2l54cwGdJSigE3Gl8pXGVK0";
        try {
            exampleNYTAPI = objectMapper.readValue(new URL(urlAPI), ExampleNYTAPI.class);
            resultListNews = new ArrayList<>();
            for (Doc i : exampleNYTAPI.getResponse().getDocs()) {
                resultListNews.add(new News("https://static01.nyt.com/" + i.getMultimedia().get(0).getUrl(), i.getWebUrl(), i.getAbstract()));
            }
        } catch (Exception ex) {
            resultListNews = new ArrayList<>();
            log.info(ex.getMessage());
        }
        return resultListNews;
    }
}
