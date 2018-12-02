package com.ly.elastic;

import com.ly.elastic.bean.Article;
import com.ly.elastic.bean.Book;
import com.ly.elastic.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticApplicationTests {

    @Autowired
    private JestClient jestClient;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void contextLoads() {
        //1、给ES中索引一个文档
        Article article = new Article();
        article.setId(1);
        article.setTitle("好消息");
        article.setAuthor("张三");
        article.setContent("HelloWord");

        Index build = new Index.Builder(article).index("ly").type("news").build();
        try {
            jestClient.execute(build);
        } catch (IOException e) {

        }
    }

    @Test
    public void search() {
        String qu = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"HelloWord\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search build = new Search.Builder(qu).addIndex("ly").addType("news").build();
        try {
            SearchResult execute = jestClient.execute(build);
            System.out.println(execute.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01() {
        Book book = new Book();
        bookRepository.index(book);

    }
}
