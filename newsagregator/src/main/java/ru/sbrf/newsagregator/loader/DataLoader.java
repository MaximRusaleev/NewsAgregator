package ru.sbrf.newsagregator.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.sbrf.newsagregator.entity.Article;
import ru.sbrf.newsagregator.entity.Example;
import ru.sbrf.newsagregator.entity.Tag;
import ru.sbrf.newsagregator.entity.User;
import ru.sbrf.newsagregator.service.TagService;
import ru.sbrf.newsagregator.service.UserService;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

//    @Autowired
//    private UserRepository userRepository;

    private final UserService userService;

    private final TagService tagService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User();
        user.setLogin("Max");
        user.setPassword("123");


        userService.save(user);

        List<User> allUser = userService.getAll();

        for (User entity : allUser) {
            System.out.println(entity.toString());
        }

        List<Tag> tagList = new ArrayList<>(
                Arrays.asList(
                        new Tag().setName("Apple"),
                        new Tag().setName("Sport"),
                        new Tag().setName("Covid")));

        tagService.saveAll(tagList);
        tagService.delById(2L);

        List<Tag> allTag = tagService.getAll();

        for (Tag entity : allTag) {
            System.out.println(entity.toString());
        }

        User user1 = new User("Alesha", "12");
        user1.addTag(new Tag().setName("Fortuna"));
        userService.save(user1);

        User user2 = new User("Masha", "26");
        userService.save(user2);
        Tag ferrari = new Tag("Ferrari");
        tagService.save(ferrari);
        ferrari.setUser(user2);
        user2.addTag(ferrari);
        userService.update(user2);

        ObjectMapper objectMapper = new ObjectMapper();
        String s = "https://newsapi.org/v2/everything?domains=yandex.ru&apiKey=cbe78b68f59e464fbecf654bc8610f76";
        //System.out.println(objectMapper.readValue(new URL(s), Example.class));

        Example exampleNew = objectMapper.readValue(new URL(s), Example.class);
        List<Article> listArticleNew = exampleNew.getArticles();

        for (Article i : listArticleNew) {
            System.out.println(i.getSource().getName() + ": " + i.getUrl());
        }
    }
}
