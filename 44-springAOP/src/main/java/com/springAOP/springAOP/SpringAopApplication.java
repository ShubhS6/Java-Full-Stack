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

	//First Example
	/*
	@Bean
	public CommandLineRunner commandLineRunner(accountDao accountDao){
		return runner->{
			demoBeforeAccount(accountDao);
		};
	}
	//if we want to execute a method right before that method so we use AOP
	public void  demoBeforeAccount(accountDao accountDao){
		accountDao.addAccount();
	}
	*/

	//Second Example
	//Execution before of any method with same name
	/*
	@Bean
	public CommandLineRunner commandLineRunner(accountDao accountDao, membershipDao membershipDao){
		return runner->{
			demoBeforeAccount(accountDao,membershipDao);
		};
	}
	//if we want to execute a method right before that method so we use AOP
	public void  demoBeforeAccount(accountDao accountDao,membershipDao membershipDao){
		accountDao.addAccount();
		membershipDao.addAccount();
	}

	 */

	//Example 3rd
	//Match only specific class Method
	//before run only when we call specific class method not for all with same name
	/*
	@Bean
	public CommandLineRunner commandLineRunner(accountDao accountDao, membershipDao membershipDao){
		return runner->{
			demoBeforeAccount(accountDao,membershipDao);
		};
	}
	//if we want to execute a method right before that method so we use AOP
	public void  demoBeforeAccount(accountDao accountDao,membershipDao membershipDao){
		accountDao.addAccount();
		membershipDao.addAccount();
	}
	 */

	//4th example
	// we goona call the before method when we encounter any method start with add
	/*
	@Bean
	public CommandLineRunner commandLineRunner(accountDao accountDao, membershipDao membershipDao){
		return runner->{
			demoBeforeAccount(accountDao,membershipDao);
		};
	}
	//if we want to execute a method right before that method so we use AOP
	public void  demoBeforeAccount(accountDao accountDao,membershipDao membershipDao){
		accountDao.addAccount();
		membershipDao.addAccount();
		accountDao.addSimpleMethod();
	}
	 */

	//5th example
	// we have to call before method inspite of any return type
	/*
	@Bean
	public CommandLineRunner commandLineRunner(accountDao accountDao, membershipDao membershipDao){
		return runner->{
			demoBeforeAccount(accountDao,membershipDao);
		};
	}
	//if we want to execute a method right before that method so we use AOP
	public void  demoBeforeAccount(accountDao accountDao,membershipDao membershipDao){
		membershipDao.addAccount();
		System.out.println(membershipDao.addSomething());
	}
	 */

	//6th Example
	//If we want the parameter type
	@Bean
	public CommandLineRunner commandLineRunner(accountDao accountDao, membershipDao membershipDao){
		return runner->{
			demoBeforeAccount(accountDao,membershipDao);
		};
	}
	//if we want to execute a method right before that method so we use AOP
	public void  demoBeforeAccount(accountDao accountDao,membershipDao membershipDao){
		accountDao.addAccount(new account("Shubham","Vishwakarma"));
	}
}
