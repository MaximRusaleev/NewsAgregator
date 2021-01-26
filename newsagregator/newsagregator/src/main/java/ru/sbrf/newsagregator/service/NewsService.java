package ru.sbrf.newsagregator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sbrf.newsagregator.entity.newsapi.Article;
import ru.sbrf.newsagregator.entity.newsapi.ExampleNewsAPI;
import ru.sbrf.newsagregator.factory.NewsFactory;
import ru.sbrf.newsagregator.factory.NewsGeneral;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class NewsService {

    public List<NewsGeneral> getNews(String interest) {
        List<NewsGeneral> newsGeneralList = new ArrayList<>();
        newsGeneralList.addAll(new NewsFactory().getNews("News").listNews(interest));
        newsGeneralList.addAll(new NewsFactory().getNews("NYT").listNews(interest));
        return newsGeneralList;
    }

}
