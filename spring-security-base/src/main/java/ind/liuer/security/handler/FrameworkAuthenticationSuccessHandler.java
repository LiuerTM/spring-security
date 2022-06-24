package ind.liuer.security.handler;

import ind.liuer.security.util.ResponseUtil;
import ind.liuer.security.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mingの
 * @date 2022/6/22 15:31
 * @since 1.0
 */
@Slf4j
@Component
public class FrameworkAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    public FrameworkAuthenticationSuccessHandler() {
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        log.info("[{}]登录成功，进入系统", authentication.getPrincipal());
        // todo 其他操作
        ResponseUtil.responseJson(response, ResultVo.success("登录成功"));
    }
}
