package ru.sbrf.newsagregator.factory;

import ru.sbrf.newsagregator.factory.NewsGeneral;

import java.util.List;

public interface NewsI {

    public List<NewsGeneral> listNews(String interest);
}
