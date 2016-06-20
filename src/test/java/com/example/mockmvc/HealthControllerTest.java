package com.example.mockmvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.support.MockApplicationTest;

@RunWith(SpringJUnit4ClassRunner.class)
@MockApplicationTest
public class HealthControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void springHealth() throws Exception {
        final String json = "{\"status\":\"Spring MVC: Up and Running!\"}";
        
		mockMvc.perform(get("/s_health"))
               .andDo(print())
               .andExpect(status().is2xxSuccessful())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(content().json(json, true));
    }
}