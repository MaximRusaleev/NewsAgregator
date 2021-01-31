package ru.sbrf.newsagregator.loader;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.sbrf.newsagregator.entity.Blog;
import ru.sbrf.newsagregator.entity.User;
import ru.sbrf.newsagregator.service.BlogService;
import ru.sbrf.newsagregator.service.UserService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final UserService userService;

    private final BlogService blogService;

    @Override
    public void run(ApplicationArguments args) {
        User user = new User();
        user.setLogin("Max");
        user.setPassword("123");

        userService.save(user);

        List<User> allUser = userService.getAll();

        for (User entity : allUser) {
            System.out.println(entity.toString());
        }

        blogService.save(new Blog("Текст 1", "Тэг 1"));
        blogService.save(new Blog("Текст 2", "Тэг 2"));
        blogService.save(new Blog("Текст 3", "Тэг 3"));
    }
}
