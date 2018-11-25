package com.julyerr.springboot.mvc;

import com.julyerr.springboot.mvc.model.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RealTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testReal(){
        Student student = testRestTemplate.getForObject("/test/stu",Student.class);
        Assert.assertTrue(123 == student.getId());
        Assert.assertTrue("name".endsWith(student.getName()));
    }
}
