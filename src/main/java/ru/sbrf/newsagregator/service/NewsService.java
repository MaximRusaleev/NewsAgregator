package ru.sbrf.newsagregator.service;

import org.springframework.stereotype.Service;
import ru.sbrf.newsagregator.factory.NewsFactory;
import ru.sbrf.newsagregator.entity.News;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {

    public List<News> getNews(String interest) {
        List<News> newsList = new ArrayList<>();
        newsList.addAll(new NewsFactory().getNews("News").listNews(interest));
        newsList.addAll(new NewsFactory().getNews("NYT").listNews(interest));
        return newsList;
    }

}
