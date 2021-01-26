package ru.sbrf.newsagregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.sbrf.newsagregator.entity.Blog;
import ru.sbrf.newsagregator.repository.BlogRepository;


import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/blog")
    public String blog(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Blog> blogs;

        if (filter != null && !filter.isEmpty()) {
            blogs = blogRepository.findByTag(filter);
        } else {
            blogs = blogRepository.findAll();
        }

        model.addAttribute("blogs", blogs);
        model.addAttribute("filter", filter);

        return "blog";
    }

    @PostMapping("/blog")
    public String add(
            //@AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Blog blog = new Blog(text, tag);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            blog.setFilename(resultFilename);
        }

        blogRepository.save(blog);

        Iterable<Blog> blogs = blogRepository.findAll();

        model.put("blogs", blogs);

        return "blog";
    }
}
