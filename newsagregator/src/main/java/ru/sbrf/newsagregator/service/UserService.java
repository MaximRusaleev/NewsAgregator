package ru.sbrf.newsagregator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import ru.sbrf.newsagregator.entity.User;
import ru.sbrf.newsagregator.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public void update(User user) {
        userRepository.save(user);
    }

    public void saveAll(List<User> userList){
        userRepository.saveAll(userList);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getById(Long id){
        return userRepository.findById(id);
    }

    public void delById(Long id){
        userRepository.deleteById(id);
    }

    public Boolean exist(Example<? extends User> example){
        return userRepository.exists(example);
    }
}