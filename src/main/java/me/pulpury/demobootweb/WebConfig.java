package me.pulpury.demobootweb;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Bean 
	public Jaxb2Marshaller marshaller() { 
	Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller(); 
	jaxb2Marshaller.setPackagesToScan(Person.class.getPackageName()); 
	return jaxb2Marshaller; 
	}


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
	
	// configureMessageConverters 추가 시 default Converter들이 사용 안됨.
//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		
//	}
	
	// extendMessageConverter 사용 시에는 Default Converter 사용 가능.
	// Converter 등록에 추천하는 방식은 '의존성 추가'.
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.extendMessageConverters(converters);
	}
	

//	@Override
//	public void addFormatters(FormatterRegistry registry) {
//		registry.addFormatter(new PersonFormatter());
//	}
	
	
	
	
}
