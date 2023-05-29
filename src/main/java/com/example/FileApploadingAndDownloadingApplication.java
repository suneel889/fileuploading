package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class FileApploadingAndDownloadingApplication {

	@Bean(name="multipartResolver")
	public CommonsMultipartResolver createCMResolver() {
		CommonsMultipartResolver c1=new CommonsMultipartResolver();	
	   c1.setMaxUploadSize(-1);
	   c1.setMaxUploadSizePerFile(50*1024*1024);
		
		return c1;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FileApploadingAndDownloadingApplication.class, args);
	}

}
