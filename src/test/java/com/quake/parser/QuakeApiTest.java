package com.quake.parser;

import com.quake.api.QuakeApi;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class QuakeApiTest {

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(new QuakeApi())
                .build();
    }

    @Test
    public void testFindGameByIdSuccess() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(get("/game/{id}", 2))
                .andExpect(status().isOk()).andReturn();

        assertEquals(200, mvcResult.getResponse().getStatus());
    }
    
    @Test
    public void testFindGameByIdNotFound() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(get("/game/{id}", 99))
                .andExpect(status().is4xxClientError()).andReturn();

        assertEquals(404, mvcResult.getResponse().getStatus());
    }
}
