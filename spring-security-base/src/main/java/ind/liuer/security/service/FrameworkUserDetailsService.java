package ind.liuer.security.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author Mingの
 * @date 2022/6/22 16:06
 * @since 1.0
 */
@Component
public class FrameworkUserDetailsService implements UserDetailsService {

    public FrameworkUserDetailsService() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User(username, "123456", Collections.emptyList());
    }
}
