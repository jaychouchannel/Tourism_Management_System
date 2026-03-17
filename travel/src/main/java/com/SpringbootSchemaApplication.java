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
public class SpringbootSchemaApplication extends SpringBootServletInitializer implements CommandLineRunner {


	@Autowired
	private TokenService tokenService;


	@Override
	public void run(String... args) throws Exception {
		try {
			tokenService.delete(null);  // 清空token数据表
		} catch (Exception e) {
			e.printStackTrace();
		}
		openBrowser("http://localhost:8080/travel/admin/dist/index.html");
		openBrowser("http://localhost:8080/travel/front/dist/index.html");
	}

	private void openBrowser(String url) {
		try {
			String os = System.getProperty("os.name").toLowerCase();
			Runtime rt = Runtime.getRuntime();
			if (os.contains("win")) {
				rt.exec(new String[]{"cmd", "/c", "start", "\"\"", url});
			} else if (os.contains("mac")) {
				rt.exec(new String[]{"open", url});
			} else {
				// Linux / Unix
				rt.exec(new String[]{"xdg-open", url});
			}
		} catch (Exception e) {
			System.err.println("Failed to open browser for URL: " + url);
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
