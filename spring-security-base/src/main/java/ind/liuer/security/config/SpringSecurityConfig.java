package ind.liuer.security.config;

import ind.liuer.security.handler.FrameworkAuthenticationEntryPoint;
import ind.liuer.security.handler.FrameworkAuthenticationFailureHandler;
import ind.liuer.security.handler.FrameworkAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Mingの
 * @date 2022/6/22 9:36
 * @since 1.0
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    public SpringSecurityConfig() {
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .formLogin()
            .usernameParameter("username")
            .passwordParameter("password")
            .loginProcessingUrl("/login")
            .successHandler(authenticationSuccessHandler())
            .failureHandler(authenticationFailureHandler())
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(authenticationEntryPoint())
            .and()
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .csrf()
            .disable();
    }


    @Bean
    public FrameworkAuthenticationSuccessHandler authenticationSuccessHandler() {
        return new FrameworkAuthenticationSuccessHandler();
    }

    @Bean
    public FrameworkAuthenticationFailureHandler authenticationFailureHandler() {
        return new FrameworkAuthenticationFailureHandler();
    }

    @Bean
    public FrameworkAuthenticationEntryPoint authenticationEntryPoint() {
        return new FrameworkAuthenticationEntryPoint();
    }
}
