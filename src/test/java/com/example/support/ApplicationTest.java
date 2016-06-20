package com.example.support;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.JerseyRsApplication;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@SpringApplicationConfiguration(classes = JerseyRsApplication.class)
@WebAppConfiguration
@org.springframework.boot.test.IntegrationTest("server.port=9000")
//@ActiveProfiles("web")
//@Sql(scripts = "classpath:data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public @interface ApplicationTest {

}
