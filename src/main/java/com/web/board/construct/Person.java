package com.web.board.construct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Profile("A_Group")
@PropertySource("classpath:/application.yml")
public class Person {

    @Autowired
    ApplicationContext ctx;

    @Autowired
    Environment environment;

    public void data(){
        Environment environment = ctx.getEnvironment();
        String id = environment.getProperty("test.id");

        String pw = environment.getProperty("test.pw");

        String url = environment.getProperty("test.url");

    }
}
