package br.com.fsp.wine.config;

import static br.com.fsp.wine.util.ConstantesURL.URL_403;
import static br.com.fsp.wine.util.ConstantesURL.URL_404;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer(){
		return (container -> container.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, URL_403),
				new ErrorPage(HttpStatus.NOT_FOUND, URL_404)));
	}
}
