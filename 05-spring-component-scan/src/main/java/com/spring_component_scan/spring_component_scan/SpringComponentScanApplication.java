package com.spring_component_scan.spring_component_scan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"hello","com.spring_component_scan.spring_component_scan"})
public class SpringComponentScanApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringComponentScanApplication.class, args);
	}

}
