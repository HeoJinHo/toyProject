package com.web.board;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class BoardApplication {



	public static final String APPLICATION_LOCATIONS = "spring.config.location="
			+ "classpath:application.yml";

	public static void main(String[] args) {
//		SpringApplication.run(BoardApplication.class, args);
		new SpringApplicationBuilder(BoardApplication.class)
				.properties(APPLICATION_LOCATIONS)
				.run(args);
	}

	@PersistenceContext
	private EntityManager em;

	/**
	 * QueryDsl JPAQueryFactory Bean 등록
	 * @return JPAQueryFactory
	 */
	@Bean
	public JPAQueryFactory jpaQueryFactory() {
		return new JPAQueryFactory(em);
	}



}
