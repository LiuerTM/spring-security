package ind.liuer.security.handler;

import ind.liuer.security.util.ResponseUtil;
import ind.liuer.security.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mingの
 * @date 2022/6/22 16:41
 * @since 1.0
 */
@Slf4j
@Component
public class FrameworkAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        log.warn("未登录访问：{}", authException.getMessage());
        ResponseUtil.responseJson(response, ResultVo.failure("请登录"));
    }
}
