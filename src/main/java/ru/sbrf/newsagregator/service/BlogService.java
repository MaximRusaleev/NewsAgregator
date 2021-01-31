package ru.sbrf.newsagregator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import ru.sbrf.newsagregator.entity.Blog;
import ru.sbrf.newsagregator.repository.BlogRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    public void saveAll(List<Blog> listBlog) {
        blogRepository.saveAll(listBlog);
    }

    public List<Blog> getAll() {
        return blogRepository.findAll();
    }

    public Optional<Blog> getById(Long id) {
        return blogRepository.findById(id);
    }

    public void delById(Long id) {
        blogRepository.deleteById(id);
    }

    public Boolean exist(Example<? extends Blog> example) {
        return blogRepository.exists(example);
    }
}
