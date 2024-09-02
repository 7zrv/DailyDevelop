package com.yoon.dailydevelop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing //등록시각, 수정시각을 위한 전체 auditing 활성화를 위한 에노테이션
@SpringBootApplication
public class DailyDevelopApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyDevelopApplication.class, args);
	}

}
