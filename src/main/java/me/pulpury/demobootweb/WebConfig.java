package me.pulpury.demobootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// order 값으로 순서를 지정할 수 있음.
		registry.addInterceptor(new GreetingInterceptor()).order(0);
		
		// addPathPatterns로 특 패턴으로 지정할 수 있음 
		registry.addInterceptor(new AnotherInterceptor())
				.addPathPatterns("/hi/**")
				.order(-1);
	}

//	@Override
//	public void addFormatters(FormatterRegistry registry) {
//		registry.addFormatter(new PersonFormatter());
//	}
	
	
}
