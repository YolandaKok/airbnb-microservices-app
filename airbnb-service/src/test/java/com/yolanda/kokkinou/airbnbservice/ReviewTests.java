package com.yolanda.kokkinou.airbnbservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.yolanda.kokkinou.airbnbservice.dto.ReviewDto;
import com.yolanda.kokkinou.airbnbservice.endpoints.ReviewApi;
import com.yolanda.kokkinou.airbnbservice.services.ReviewService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.EntityManagerFactory;
import javax.servlet.Filter;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReviewApi.class)
@WithMockUser
public class ReviewTests {

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReviewService service;

    @MockBean
    private EntityManagerFactory factory;

    @MockBean
    private UserDetailsService userDetailsService;

    @Test
    public void create() throws Exception {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setComment("Hello");
        reviewDto.setScore(3);
        reviewDto.setUnitId(1L);
        reviewDto.setUserId(1L);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(reviewDto);

        this.mockMvc
                .perform(post("/api/reviews")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void create_stars_less_than_zero() throws Exception {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setComment("Hello");
        reviewDto.setScore(-3);
        reviewDto.setUnitId(1L);
        reviewDto.setUserId(1L);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(reviewDto);

        MvcResult mvcResult = this.mockMvc
                .perform(post("/api/reviews")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void create_stars_greater_than_five() throws Exception {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setComment("Hello");
        reviewDto.setScore(8);
        reviewDto.setUnitId(1L);
        reviewDto.setUserId(1L);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(reviewDto);

        MvcResult mvcResult = this.mockMvc
                .perform(post("/api/reviews")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(status().isBadRequest())
                .andReturn();
    }
}
