package ind.liuer.security.handler;

import ind.liuer.security.util.ResponseUtil;
import ind.liuer.security.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mingの
 * @date 2022/6/22 15:56
 * @since 1.0
 */
@Slf4j
@Component
public class FrameworkAuthenticationFailureHandler implements AuthenticationFailureHandler {

    public FrameworkAuthenticationFailureHandler() {
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {
        log.warn("认证失败，{}", exception.getMessage());
        // todo 其他操作
        ResponseUtil.responseJson(response, ResultVo.failure("登录失败：" + exception.getMessage()));
    }
}
