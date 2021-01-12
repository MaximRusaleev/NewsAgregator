package ru.sbrf.newsagregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.sbrf.newsagregator.entity.Tag;
import ru.sbrf.newsagregator.repository.TagRepository;

import java.util.List;

@RestController
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("/tag")
    public List<Tag> allTags() {
        return tagRepository.findAll();
    }

    @GetMapping("/tag/{id}")
    public String getTags(@PathVariable("id") Long id) {
        return tagRepository.findById(id).orElse(null).getName();
    }

}
