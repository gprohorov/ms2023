package edu.pro.ms2023;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@SpringBootTest
class Ms2023ApplicationTests {

    @Test
    void contextLoads() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        Assertions.assertNotNull(context);
    }

}
