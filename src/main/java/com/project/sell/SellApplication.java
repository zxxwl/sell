package com.project.sell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
//@EntityScan("com.project.sell.dataobject") // 用于扫描JPA实体类 @Entity
//@ComponentScan(basePackages = "com.project.sell") // 用于扫描@Controller @Service @Component @Repository
@SpringBootApplication
public class SellApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellApplication.class, args);
	}

}
