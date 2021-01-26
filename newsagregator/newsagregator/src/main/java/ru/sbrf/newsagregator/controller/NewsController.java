package ru.sbrf.newsagregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sbrf.newsagregator.factory.NewsGeneral;
import ru.sbrf.newsagregator.service.NewsService;

import java.io.IOException;
import java.util.List;

@Controller
public class NewsController {
    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {

        List<NewsGeneral> listNews;

        if (filter != null && !filter.isEmpty()) {
            listNews = newsService.getNews(filter);
            model.addAttribute("news", listNews);
            model.addAttribute("filter", filter);

        } else {
            listNews = newsService.getNews("");
            model.addAttribute("news", listNews);
        }
        return "news";
    }
}
