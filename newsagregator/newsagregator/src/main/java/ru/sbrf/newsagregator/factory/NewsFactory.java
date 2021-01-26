package ru.sbrf.newsagregator.factory;

import java.util.ArrayList;
import java.util.List;

public class NewsFactory {

    public NewsI getNews(String typeNews) {
        if (typeNews.equals("News"))
            return new NewsAPI();
        if (typeNews.equals("NYT"))
            return new NYTAPI();

        return null;
    }

    /*List<NewsGeneral> newsGeneralList = new ArrayList<>();
        newsGeneralList.addAll(new NewsAPI().listNews());
        newsGeneralList.addAll(new NYTAPI().listNews());

    //return new NewsAPI();new NYTAPI()
        return newsGeneralList;*/
}
