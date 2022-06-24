package ind.liuer.security.config;

import ind.liuer.security.handler.FrameworkAuthenticationEntryPoint;
import ind.liuer.security.handler.FrameworkAuthenticationFailureHandler;
import ind.liuer.security.handler.FrameworkAuthenticationSuccessHandler;
import ind.liuer.security.support.SmsCodeAuthenticationProvider;
import ind.liuer.security.support.SmsCodeSecurityConfigurer;
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

    private final FrameworkAuthenticationSuccessHandler authenticationSuccessHandler;
    private final FrameworkAuthenticationFailureHandler authenticationFailureHandler;
    private final FrameworkAuthenticationEntryPoint authenticationEntryPoint;

    public SpringSecurityConfig(FrameworkAuthenticationSuccessHandler authenticationSuccessHandler,
                                FrameworkAuthenticationFailureHandler authenticationFailureHandler,
                                FrameworkAuthenticationEntryPoint authenticationEntryPoint) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
        this.authenticationFailureHandler = authenticationFailureHandler;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .formLogin()
            .usernameParameter("username")
            .passwordParameter("password")
            .loginProcessingUrl("/login")
            .successHandler(authenticationSuccessHandler)
            .failureHandler(authenticationFailureHandler)
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(authenticationEntryPoint)
            .and()
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .csrf()
            .disable();

        SmsCodeSecurityConfigurer<HttpSecurity> smsCodeSecurityConfigurer = new SmsCodeSecurityConfigurer<>();
        smsCodeSecurityConfigurer
            .successHandler(authenticationSuccessHandler)
            .failureHandler(authenticationFailureHandler);
        httpSecurity
            .authenticationProvider(new SmsCodeAuthenticationProvider())
            .apply(smsCodeSecurityConfigurer);
    }
}
