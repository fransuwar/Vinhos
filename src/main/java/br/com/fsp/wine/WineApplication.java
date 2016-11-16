package br.com.fsp.wine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class WineApplication extends SpringBootServletInitializer{

	private static Class<WineApplication> applicationClass = WineApplication.class;
	
	public static void main(String[] args) {
		SpringApplication.run(WineApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(applicationClass);
	}
}
