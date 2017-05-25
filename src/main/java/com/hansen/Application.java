package com.hansen;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
/**
 * Application �O SpringBoot ���Ұʦa��
 * @author hansen.sen
 *
 */
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })//�i���L���ұb�K�u�X����
public class Application extends SpringBootServletInitializer {

 public static void main(String[] args) {
  SpringApplication.run(Application.class, args);
    }
 
 @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
 
 @PostConstruct
 public void postConstruct() {
 }

}