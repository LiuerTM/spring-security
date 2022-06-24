package ind.liuer.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Mingの
 * @date 2022/6/23 10:27
 * @since 1.0
 */
@Slf4j
@SpringBootApplication
public class SpringSecurityQuickStartApplication {

    public static void main(String[] args) {
        log.info("SpringSecurity-QuickStart System is starting .....");
        SpringApplication.run(SpringSecurityQuickStartApplication.class, args);
        log.info("SpringSecurity-QuickStart System is running  .....");
    }
}
