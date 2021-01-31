package ru.sbrf.newsagregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String blog(@RequestParam(required = false, defaultValue = "") String filter,
                       Model model,
                       @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Blog> page;

        if (filter != null && !filter.isEmpty()) {
            page = blogRepository.findByTag(filter, pageable);
        } else {
            page = blogRepository.findAll(pageable);
        }

        model.addAttribute("page", page);
        model.addAttribute("url", "/blog");
        model.addAttribute("filter", filter);

        return "blog";
    }

    @PostMapping("/blog")
    public String add(
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model,
            @RequestParam("file") MultipartFile file,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable
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

        Page<Blog> page = blogRepository.findAll(pageable);

        model.put("page", page);
        model.put("url", "/blog");

        return "blog";
    }

    @GetMapping("/blog/{id}")
    public String getBlog(@PathVariable("id") Long id, Model model) {
        Blog blogs;

        if (id != null) {
            blogs = blogRepository.findById(id).orElse(null);
        } else {
            blogs = null;
        }

        model.addAttribute("blogs", blogs);

        return "blog_edit";
    }

    @PostMapping("/blog/{id}")
    public String updateBlog(
            @PathVariable("id") Long id,
            @RequestParam String text,
            @RequestParam String tag, Model model
    ) {
        Blog blogs;

        if (id != null) {
            blogs = blogRepository.findById(id).orElse(null);
        } else {
            blogs = null;
        }

        blogs.setTag(tag);
        blogs.setText(text);

        blogRepository.save(blogs);

        model.addAttribute("blogs", blogs);

        return "blog_edit";
    }
}
