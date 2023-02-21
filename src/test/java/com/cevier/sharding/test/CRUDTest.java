package com.cevier.sharding.test;

import com.cevier.sharding.pojo.Paragraph;
import com.cevier.sharding.pojo.User;
import com.cevier.sharding.service.ParagraphService;
import com.cevier.sharding.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author: cevier.wei
 * @date: 2023/2/10 11:46
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CRUDTest {

    @Resource
    private UserService userService;

    @Resource
    private ParagraphService paragraphService;

    @Test
    public void getUser() {
        var user = userService.lambdaQuery().eq(User::getId, 1).one();
        System.out.println(user);
    }

    @Test
    public void addParagraph() {
        var p1 = new Paragraph(4L, "hey", 1L);
        var p2 = new Paragraph(5L, "im", 1L);
        paragraphService.save(p1);
        paragraphService.save(p2);
    }

    @Test
    public void geParagraphByArticleId() {
        var paragraphs = paragraphService.getByArticleId(2);
        paragraphs.forEach(System.out::println);
    }
}
