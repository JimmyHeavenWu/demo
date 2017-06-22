package com.example.demo.controller;

/**
 * Created by wuj42 on 6/22/2017.
 */

import com.example.demo.domain.Book;
import com.example.demo.util.JsonHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createBookTest() throws Exception {

        String bookJson = "{\"title\": \"book\",\"author\": \"jimmy\",\"time\": \"2017-06-19T17:14:00\"}";

        mockMvc.perform(post("/api/v1/books")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(bookJson))
                .andExpect(status().isOk());
    }

}
