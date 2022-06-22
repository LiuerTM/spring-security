package ind.liuer.security.util;

import ind.liuer.security.exception.FrameworkException;
import ind.liuer.security.vo.ResultVo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Mingの
 * @date 2022/6/22 15:35
 * @since 1.0
 */
public final class ResponseUtil {

    public static void responseJson(HttpServletResponse response, ResultVo<?> resultVo) {
        try {
            response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.getWriter().write(JsonUtil.jsonString(resultVo));
        } catch (IOException e) {
            throw new FrameworkException("序列化JSON出现异常: " + e.getMessage(), e);
        }
    }
}
