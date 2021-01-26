package ru.sbrf.newsagregator.factory;

public class NewsGeneral {

    private String urlToImage;
    private String url;
    private String title;

    public NewsGeneral(String urlToImage, String url, String title) {
        this.urlToImage = urlToImage;
        this.url = url;
        this.title = title;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
