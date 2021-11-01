package com.springboot.library;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.springboot.library.dao.UserDao;
import com.springboot.library.model.User;

@SpringBootApplication
public class LibraryManagementSystemApplication {

	 @Autowired
	    private BCryptPasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}
	@Bean
    public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials (true);
		corsConfiguration.setAllowedOrigins (Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders (Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type", "Accept", "Authorization", "Origin, Accept", "X-Requested-With",

		"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders (Arrays.asList("Origin", "Content-Type", "Accept", "Authorization", "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods (Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration ("/**", corsConfiguration);
		
		return new CorsFilter(urlBasedCorsConfigurationSource);
    }
//	@Bean
//    public CommandLineRunner init(UserDao userDao){
//        return args -> {
//            User user1 = new User();
//            user1.setFirstName("Krsihna");
//            user1.setUsername("kp@gmail.com");
//            user1.setPassword(passwordEncoder.encode("123456"));
//            userDao.save(user1);
//        };
//    }
}
