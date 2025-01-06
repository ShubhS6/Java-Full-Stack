package com.springAOP.springAOP;

import com.springAOP.springAOP.dao.accountDao;
import com.springAOP.springAOP.dao.membershipDao;
import com.springAOP.springAOP.model.account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(accountDao accountDao, membershipDao membershipDao){
		return runner->{
			demoBeforeAccount(accountDao,membershipDao);
		};
	}
	//if we want to execute a method right before that method so we use AOP
	public void  demoBeforeAccount(accountDao accountDao,membershipDao membershipDao){
		accountDao.addSimpleMethod();
	}
}
