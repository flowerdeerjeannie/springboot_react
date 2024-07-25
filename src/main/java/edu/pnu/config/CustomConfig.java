package edu.pnu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.NonNull;

//CORS 설정하겠음 
//왜냐면 3000이랑 8080은 (리액트서버랑 부트 서버) 서로 매핑이 안되게 되어있어서 
//그 요구가 들어와도 충돌이 아니라 연결이 되게 하기 위함

@Configuration
public class CustomConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(@NonNull CorsRegistry registry) {

//		registry.addMapping("/board/**")
//				.allowedMethods(HttpMethod.GET.name(), //get, post 메소드에 대해서.
//								HttpMethod.POST.name())
//				.allowedOrigins("http://localhost:3000", "http://127.0.0.1:3000");
//		
//		registry.addMapping("/member/**")	//주소는 member 포함하는 모든 하부 주소 ㅇㅋ
//				.allowedMethods(HttpMethod.GET.name(), //get, put 메소드에 대해서만.
//								HttpMethod.PUT.name())
//				.allowedOrigins("http://localhost:3000");
		
		registry.addMapping("/**") //모든 주소에 대해서
				.allowCredentials(true)						//클라이언트가 쿠키(인증헤더)를 포함하도록 함
				.allowedHeaders(HttpHeaders.AUTHORIZATION)	//클라이언트가 요청 시 사용할 수 있는 헤더 지정
				.exposedHeaders(HttpHeaders.AUTHORIZATION) //클라이언트가 응답에 접근할 수 있는 헤더 지정
				.allowedMethods(HttpMethod.GET.name(),		//클라이언트가 요청 시 사용할수있는 method들
								HttpMethod.POST.name(),
								HttpMethod.PUT.name(),
								HttpMethod.DELETE.name())
				.allowedOrigins("http://localhost:3000",	//CORS 요청을 허용할 출처 지정
								"http://127.0.0.1:3000");
	}
	
}
