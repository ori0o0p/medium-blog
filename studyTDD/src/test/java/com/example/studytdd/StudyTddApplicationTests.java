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
        SearchResult result = naverSearchAPI.search();
        Assertions.assertEquals(result.items().size(), 5);
    }


}

record SearchResult(String lastBuildDate, String total, String start, String display, List<Item> items) {
}

record Item(String title, String link, String category, String description, String telephone, String address,
            String roadAddress, String mapx, String map) {
}
