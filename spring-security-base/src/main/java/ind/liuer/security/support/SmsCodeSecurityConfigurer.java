package ind.liuer.security.support;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

/**
 * @author Mingの
 * @date 2022/6/23 15:19
 * @since 1.0
 */
public class SmsCodeSecurityConfigurer<B extends HttpSecurityBuilder<B>> extends AbstractHttpConfigurer<SmsCodeSecurityConfigurer<B>, B> {


    private AuthenticationSuccessHandler authenticationSuccessHandler;

    private AuthenticationFailureHandler authenticationFailureHandler;

    @Override
    public void configure(B builder) {
        SmsCodeAuthenticationFilter smsCodeAuthenticationFilter = new SmsCodeAuthenticationFilter();
        AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);
        smsCodeAuthenticationFilter.setAuthenticationManager(authenticationManager);
        smsCodeAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        smsCodeAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
        smsCodeAuthenticationFilter.setAuthenticationDetailsSource(new WebAuthenticationDetailsSource());

        builder.addFilterAfter(smsCodeAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    public SmsCodeSecurityConfigurer<B> successHandler(AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
        return this;
    }

    public SmsCodeSecurityConfigurer<B> failureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
        return this;
    }
}
