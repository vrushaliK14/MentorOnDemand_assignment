package com.ibm.vil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDiscoveryClient
@SpringBootApplication
public class MyApplication /*extends SpringBootServletInitializer*/ { 
	private static final Logger log = LoggerFactory.getLogger(MyApplication.class);
	
	
	
  /*  public MyApplication()
   {
       super();
       setRegisterErrorPageFilter(false);
   }*/

   /* @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MyApplication.class);
        
    } */
	
	public static void main(String[] args) {
		log.info("Main Application");
		/*ApplicationContext context=SpringApplication.run(MyApplication.class, args);*/
		 SpringApplication.run(MyApplication.class, args);

    }       
}            
