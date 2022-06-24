package ind.liuer.security.support;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

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

    private static final String FRAMEWORK_SMS_CODE_PHONE_KEY = "phone";

    private static final String FRAMEWORK_SMS_CODE_CODE_KEY = "code";

    private static final String LOGIN_PATH = "/login_sms";

    private static final String LOGIN_METHOD = "POST";

    private static final AntPathRequestMatcher DEFAULT_ANT_PATH_REQUEST_MATCHER = new AntPathRequestMatcher(LOGIN_PATH, LOGIN_METHOD);

    private String phoneParameter = FRAMEWORK_SMS_CODE_PHONE_KEY;

    private String codeParameter = FRAMEWORK_SMS_CODE_CODE_KEY;

    public SmsCodeAuthenticationFilter() {
        super(DEFAULT_ANT_PATH_REQUEST_MATCHER);
    }

    public SmsCodeAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(DEFAULT_ANT_PATH_REQUEST_MATCHER, authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String phone = obtainPhone(request);
        phone = phone != null ? phone : "";
        String code = obtainCode(request);
        code = code != null ? code : "";
        SmsCodeAuthenticationToken authRequest = new SmsCodeAuthenticationToken(phone, code);
        authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
        return this.getAuthenticationManager().authenticate(authRequest);
    }

    private String obtainPhone(HttpServletRequest request) {
        return request.getParameter(this.phoneParameter);
    }

    private String obtainCode(HttpServletRequest request) {
        return request.getParameter(this.codeParameter);
    }

    public void setPhoneParameter(String phoneParameter) {
        Assert.hasText(phoneParameter, "Phone parameter must not be empty or null");
        this.phoneParameter = phoneParameter;
    }

    public void setCodeParameter(String codeParameter) {
        Assert.hasText(codeParameter, "Code parameter must not be empty or null");
        this.codeParameter = codeParameter;
    }

    public String getPhoneParameter() {
        return phoneParameter;
    }

    public String getCodeParameter() {
        return codeParameter;
    }
}
