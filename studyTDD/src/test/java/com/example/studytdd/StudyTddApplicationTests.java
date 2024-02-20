package com.example.studytdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudyTddApplicationTests {
    @Autowired
    private NaverSearchAPI naverSearchAPI;

    @Test
    void testGet() {
        SearchResult result = naverSearchAPI.search(new SearchRequest("옷",5, 1,"random"));
        Assertions.assertEquals(result.items().size(), 5);
    }


}
