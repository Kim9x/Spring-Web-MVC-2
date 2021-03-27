package me.pulpury.demobootweb;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		// order 값으로 순서를 지정할 수 있음.
//		registry.addInterceptor(new GreetingInterceptor()).order(0);
//		
//		// addPathPatterns로 특 패턴으로 지정할 수 있음 
//		registry.addInterceptor(new AnotherInterceptor())
//				.addPathPatterns("/hi/**")
//				.order(-1);
//	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		// addResourceHandler의 패턴이 들어오면
		// addResourceLocation의 값에 설정된 리소스를 사용한다.
		// setCacheControl은 캐시 값 설정이며 다른 설정 값들을 사용할 수도 있다.
		registry.addResourceHandler("/mobile/**")
				.addResourceLocations("classpath:/test/")
				.setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
	}

//	@Override
//	public void addFormatters(FormatterRegistry registry) {
//		registry.addFormatter(new PersonFormatter());
//	}
	
	
	
	
}
