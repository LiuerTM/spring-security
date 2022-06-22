package ind.liuer.security.support;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author Mingの
 * @date 2022/6/22 16:10
 * @since 1.0
 */
@Component
public class PlainPasswordEncoder implements PasswordEncoder {

    public PlainPasswordEncoder() {
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return (String) rawPassword;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (!StringUtils.hasText(rawPassword)) {
            return false;
        }
        return encode(rawPassword).equals(encodedPassword);
    }
}
