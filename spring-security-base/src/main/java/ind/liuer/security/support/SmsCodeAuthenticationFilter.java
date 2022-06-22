package ind.liuer.security.support;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mingの
 * @date 2022/6/22 16:57
 * @since 1.0
 */
public class SmsCodeAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    protected SmsCodeAuthenticationFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String mobile = request.getParameter("mobile");
        mobile = mobile != null ? mobile : "";
        String code = request.getParameter("code");
        code = code != null ? code : "";
        SmsCodeAuthenticationToken authRequest = new SmsCodeAuthenticationToken(mobile, code);
        authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
