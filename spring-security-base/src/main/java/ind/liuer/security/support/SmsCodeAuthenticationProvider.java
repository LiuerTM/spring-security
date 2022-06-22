package ind.liuer.security.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * @author Mingの
 * @date 2022/6/22 17:07
 * @since 1.0
 */
@Slf4j
public class SmsCodeAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Assert.isInstanceOf(SmsCodeAuthenticationToken.class, authentication, "Only UsernamePasswordAuthenticationToken is supported");
        SmsCodeAuthenticationToken token = (SmsCodeAuthenticationToken) authentication;
        String mobile = (String) token.getPrincipal();
        String code = (String) token.getCredentials();
        log.info("手机号[{}]，验证码[{}]，开始登录", mobile, code);
        String codeInStore = getCode(mobile);
        if(!StringUtils.hasText(code) || !code.equals(codeInStore)) {

        }
        return null;
    }

    private String getCode(String mobile) {
        return "1234";
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
