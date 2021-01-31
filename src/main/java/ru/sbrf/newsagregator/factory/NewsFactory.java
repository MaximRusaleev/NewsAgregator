package ru.sbrf.newsagregator.factory;

public class NewsFactory {

    public INews getNews(String typeNews) {
        if (typeNews.equals("News"))
            return new APINews();
        if (typeNews.equals("NYT"))
            return new NewYorkTimesAPI();

        return null;
    }
}
