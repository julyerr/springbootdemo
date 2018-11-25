package com.julyerr.springboot.mvc;

import com.alibaba.fastjson.JSON;
import com.julyerr.springboot.mvc.model.Student;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contentTest() throws Exception {
        mockMvc.perform(request(HttpMethod.GET, "/test/content"))
                .andExpect(status().isOk())
//                .andExpect(content().string("\"ok\""));
                .andExpect(content().string(equalTo("\"ok\"")))
                .andExpect(content().string(containsString("ok")));
    }

    @Test
    public void getTest() throws Exception {
        mockMvc.perform(get("/test/stu"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("name"))
                .andDo(print());
    }

    @Test
    public void saveTest() throws Exception {
        Student student = new Student();
        student.setId(123);
        student.setName("name");
        String stuStr = JSON.toJSONString(student);
        mockMvc.perform(post("/test/stu")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(stuStr.getBytes()))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Rule
    public ContiPerfRule rule = new ContiPerfRule();

    @Test
    @PerfTest(threads = 10,invocations = 100)
    public void performanceTest() throws Exception{
        getTest();
    }
}
