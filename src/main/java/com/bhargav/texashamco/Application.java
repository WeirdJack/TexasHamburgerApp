package com.bhargav.texashamco;

import com.bhargav.texashamco.repository.*;
import com.bhargav.texashamco.repository.interceptor.InterceptorRepository;
import com.bhargav.texashamco.repository.security.UserAuthRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserAuthRepository.class)
@EnableMongoRepositories(basePackageClasses
        = {
        LocationRepository.class, MenuRepository.class, OpenHoursRepository.class,
        OrderRepository.class, ReservationRepository.class, InterceptorRepository.class
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
