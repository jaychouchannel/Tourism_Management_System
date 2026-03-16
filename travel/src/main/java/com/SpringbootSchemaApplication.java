package com;

import com.service.TokenService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages = {"com.dao"})
public class SpringbootSchemaApplication extends SpringBootServletInitializer     implements CommandLineRunner {


	@Autowired
	private TokenService tokenService;


	@Override
	public void run(String... args) throws Exception {
		try {
			tokenService.delete(null);  // 清空数据表
			Runtime.getRuntime().exec("cmd /c start http://localhost:8080/travel/admin/dist/index.html");
			Runtime.getRuntime().exec("cmd /c start http://localhost:8080/travel/front/dist/index.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSchemaApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(SpringbootSchemaApplication.class);
    }
}
