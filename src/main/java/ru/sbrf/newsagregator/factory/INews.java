package ru.sbrf.newsagregator.factory;


import ru.sbrf.newsagregator.entity.News;

import java.util.List;

public interface INews {

    List<News> listNews(String interest);
}
