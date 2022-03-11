package com.melon.jobrecruitmentsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JobRecruitmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobRecruitmentSystemApplication.class, args);
	}

}
