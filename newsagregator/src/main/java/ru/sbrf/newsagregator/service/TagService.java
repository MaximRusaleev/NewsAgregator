package ru.sbrf.newsagregator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import ru.sbrf.newsagregator.entity.Tag;
import ru.sbrf.newsagregator.entity.User;
import ru.sbrf.newsagregator.repository.TagRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public void save(Tag tag) {
        tagRepository.save(tag);
    }

    public void saveAll(List<Tag> listTag) {
        tagRepository.saveAll(listTag);
    }

    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    public Optional<Tag> getById(Long id) {
        return tagRepository.findById(id);
    }

    public void delById(Long id) {
        tagRepository.deleteById(id);
    }

    public Boolean exist(Example<? extends Tag> example) {
        return tagRepository.exists(example);
    }
}
