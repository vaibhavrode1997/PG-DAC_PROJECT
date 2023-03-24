package com.demo.EventManagementPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventManagementPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventManagementPortalApplication.class, args);
	}

	
//	@SuppressWarnings("rawtypes")
//	@Bean
//	public FilterRegistrationBean coresFilter()
//	{
//		UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
//		
//		CorsConfiguration corsConfiguration= new CorsConfiguration();
//		corsConfiguration.setAllowCredentials(true);
//		corsConfiguration.addAllowedOriginPattern("*");
//		corsConfiguration.addAllowedHeader("Authorization");
//		corsConfiguration.addAllowedHeader("Content-Type");
//		corsConfiguration.addAllowedHeader("Accept");
//		corsConfiguration.addAllowedMethod("POST");
//		corsConfiguration.addAllowedMethod("GET");
//		corsConfiguration.addAllowedMethod("DELETE");
//		corsConfiguration.addAllowedMethod("PUT");
//		corsConfiguration.addAllowedMethod("OPTIONS");
//		corsConfiguration.setMaxAge(3600L);
//		
//		source.registerCorsConfiguration("/**", corsConfiguration);
//		FilterRegistrationBean bean=FilterRegistrationBean(new CorsFilter(source));
//		return bean;
//	}

}
